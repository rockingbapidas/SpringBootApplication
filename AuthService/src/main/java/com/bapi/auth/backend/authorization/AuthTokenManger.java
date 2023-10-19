package com.bapi.auth.backend.authorization;

import com.bapi.auth.backend.data.DataApi;
import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.Token;
import com.bapi.auth.backend.jwt.JwtAuthManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AuthTokenManger implements IAuthTokenManager {
    private final String TAG = AuthTokenManger.class.getSimpleName();
    @Autowired
    private JwtAuthManager jwtAuthManager;
    @Autowired
    private DataApi dataApi;
    @Autowired
    private IMapper<AuthToken, Token> authTokenTokenIMapper;

    @Override
    @Transactional
    public AuthToken createToken(String userName, String deviceType, String deviceId) {
        Logger.getLogger(TAG).info("createToken " + userName + " " + deviceType + " " + deviceId);
        return getToken(userName, deviceType, deviceId);
    }

    @Transactional
    private AuthToken getToken(String userName, String deviceType, String deviceId) {
        Logger.getLogger(TAG).info("getToken " + userName + " " + deviceType + " " + deviceId);

        //Check for existing token and validate its valid ir not if valid return that existing token
        Token existingToken = dataApi.tokenRepository().findTokenByUserNameAndDeviceId(deviceId, userName);
        if (existingToken != null) {
            try {
                if (jwtAuthManager.validateToken(existingToken.getAccessToken(), userName)) {
                    return authTokenTokenIMapper.mapTo(existingToken);
                }
            } catch (Exception e) {
                Logger.getLogger(TAG).info("Catch " + e);
                //Delete token
                dataApi.tokenRepository().delete(existingToken);
            }
        }

        //Create or generate new token
        AuthToken authToken = getAuthToken(userName, deviceType, deviceId);

        //Save new generated token
        dataApi.tokenRepository().save(authTokenTokenIMapper.mapFrom(authToken));

        return authToken;
    }

    private AuthToken getAuthToken(String userName, String deviceType, String deviceId) {
        Logger.getLogger(TAG).info("getAuthToken " + userName + " " + deviceType + " " + deviceId);
        String token = jwtAuthManager.generateToken(userName);
        Long expiration = jwtAuthManager.extractExpiration(token).getTime();
        return AuthToken.builder()
                .deviceUniqueId(deviceId)
                .deviceType(deviceType)
                .accessToken(token)
                .expiryTime(expiration)
                .tokenType(TokenType.JWT.name())
                .userName(userName)
                .build();
    }

    @Override
    @Transactional
    public void destroyToken(String userName, String deviceId) {
        Logger.getLogger(TAG).info("destroyToken " + userName + " " + deviceId);
        destroy(userName, deviceId);
    }

    @Transactional
    private void destroy(String userName, String deviceId) {
        Logger.getLogger(TAG).info("destroy " + userName + " " + deviceId);
        Token existingToken = dataApi.tokenRepository().findTokenByUserNameAndDeviceId(deviceId, userName);
        //Todo black list existing token and save to blacklisted cached database

        //Delete token
        dataApi.tokenRepository().delete(existingToken);
    }

    enum TokenType {
        JWT
    }
}
