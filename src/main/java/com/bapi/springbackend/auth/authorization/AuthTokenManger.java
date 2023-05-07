package com.bapi.springbackend.auth.authorization;

import com.bapi.springbackend.auth.jwt.IJwtAuthService;
import com.bapi.springbackend.domain.Person;
import com.bapi.springbackend.domain.Token;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.repository.IPersonRepository;
import com.bapi.springbackend.repository.ITokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Component
public class AuthTokenManger implements IAuthTokenManager {
    private final String TAG = AuthTokenManger.class.getSimpleName();
    @Autowired
    private IJwtAuthService jwtAuthService;
    @Autowired
    private ITokenRepository tokenRepository;
    @Autowired
    private IPersonRepository personRepository;
    @Autowired
    private IMapper<AuthToken, Token> tokenMapper;

    @Override
    @Transactional
    public Token createToken(Person person, String deviceType, String deviceId) {
        Logger.getLogger(TAG).info("createToken " + person + " " + deviceType + " " + deviceId);
        return getToken(person, deviceType, deviceId);
    }

    @Transactional
    private Token getToken(Person person, String deviceType, String deviceId) {
        Logger.getLogger(TAG).info("getToken " + person + " " + deviceType + " " + deviceId);
        //Check for existing token and validate its valid ir not if valid return that existing token
        Token existingToken = tokenRepository.findTokenByUserNameAndDeviceId(deviceId, person.getUserName());
        if (existingToken != null) {
            try {
                if (jwtAuthService.validateToken(existingToken.getAccessToken(), person.getUserName())) {
                    return existingToken;
                }
            } catch (Exception e) {
                Logger.getLogger(TAG).info("Catch " + e);
                //Delete token
                tokenRepository.delete(existingToken);
            }
        }

        //Create or generate new token
        AuthToken authToken = getAuthToken(person, deviceType, deviceId);

        //Save new generated token
        Token newToken = tokenMapper.mapFrom(authToken);

        return tokenRepository.save(newToken);
    }

    private AuthToken getAuthToken(Person person, String deviceType, String deviceId) {
        Logger.getLogger(TAG).info("getAuthToken " + person + " " + deviceType + " " + deviceId);
        String token = jwtAuthService.generateToken(person.getUserName());
        Long expiration = jwtAuthService.extractExpiration(token).getTime();
        return AuthToken.builder()
                .setDeviceUniqueId(deviceId)
                .setDeviceType(deviceType)
                .setAccessToken(token)
                .setExpiryTime(expiration)
                .setTokenType(TokenType.JWT.name())
                .setUserName(person.getUserName())
                .build();
    }

    @Override
    @Transactional
    public void destroyToken(Person person, String deviceId) {
        Logger.getLogger(TAG).info("destroyToken " + person + " " + deviceId);
        destroy(person, deviceId);
    }

    @Transactional
    private void destroy(Person person, String deviceId) {
        Logger.getLogger(TAG).info("destroy " + person + " " + deviceId);
        Token existingToken = tokenRepository.findTokenByUserNameAndDeviceId(deviceId, person.getUserName());
        //Todo black list existing token and save to blacklisted cached database

        //Delete token
        tokenRepository.delete(existingToken);
    }

    enum TokenType {
        JWT
    }
}
