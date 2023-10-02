package com.bapi.auth.authorization.mapper;

import com.bapi.auth.authorization.AuthToken;
import com.bapi.domain.IMapper;
import com.bapi.domain.Token;
import org.springframework.stereotype.Component;

@Component
public class AuthTokenMapper implements IMapper<AuthToken, Token> {
    @Override
    public Token mapFrom(AuthToken authToken) {
        return new Token(
                authToken.getDeviceUniqueId(),
                authToken.getDeviceType(),
                authToken.getExpiryTime(),
                authToken.getAccessToken(),
                authToken.getTokenType(),
                authToken.getUserName()
        );
    }

    @Override
    public AuthToken mapTo(Token token) {
        return AuthToken.builder()
                .setDeviceUniqueId(token.getDeviceUniqueId())
                .setDeviceType(token.getDeviceType())
                .setAccessToken(token.getAccessToken())
                .setExpiryTime(token.getExpiresAt())
                .setTokenType(token.getTokenType())
                .setUserName(token.getUserName())
                .build();
    }
}
