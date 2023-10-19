package com.bapi.auth.backend.authorization.mapper;

import com.bapi.auth.backend.authorization.AuthToken;
import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.Token;
import org.springframework.stereotype.Component;

@Component
public class AuthTokenMapper implements IMapper<AuthToken, Token> {
    @Override
    public Token mapFrom(AuthToken authToken) {
        return Token.builder()
                .deviceUniqueId(authToken.getDeviceUniqueId())
                .deviceType(authToken.getDeviceType())
                .accessToken(authToken.getAccessToken())
                .expiresAt(authToken.getExpiryTime())
                .tokenType(authToken.getTokenType())
                .userName(authToken.getUserName())
                .build();
    }

    @Override
    public AuthToken mapTo(Token token) {
        return AuthToken.builder()
                .deviceUniqueId(token.getDeviceUniqueId())
                .deviceType(token.getDeviceType())
                .accessToken(token.getAccessToken())
                .expiryTime(token.getExpiresAt())
                .tokenType(token.getTokenType())
                .userName(token.getUserName())
                .build();
    }
}
