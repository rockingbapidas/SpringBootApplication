package com.bapi.springbackend.auth.authorization;

import com.bapi.springbackend.domain.Token;
import com.bapi.springbackend.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class TokenAuthMapper implements IMapper<AuthToken, Token> {
    @Override
    public Token mapFrom(AuthToken authToken) {
        Token token = new Token();
        token.setDeviceUniqueId(authToken.getDeviceUniqueId());
        token.setDeviceType(authToken.getDeviceType());
        token.setExpiresAt(authToken.getExpiryTime());
        token.setAccessToken(authToken.getAccessToken());
        token.setTokenType(authToken.getTokenType());
        token.setUserName(authToken.getUserName());
        return token;
    }
}
