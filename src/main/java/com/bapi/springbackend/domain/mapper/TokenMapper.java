package com.bapi.springbackend.domain.mapper;

import com.bapi.springbackend.dao.IdTokenEntity;
import com.bapi.springbackend.domain.Token;
import com.bapi.springbackend.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class TokenMapper implements IMapper<IdTokenEntity, Token> {
    @Override
    public Token mapFrom(IdTokenEntity idTokenEntity) {
        Token token = new Token();
        token.setDeviceUniqueId(idTokenEntity.getDeviceUniqueId());
        token.setDeviceType(idTokenEntity.getDeviceType());
        token.setExpiresAt(idTokenEntity.getExpiresAt());
        token.setAccessToken(idTokenEntity.getAccessToken());
        token.setTokenType(idTokenEntity.getTokenType());
        token.setUserName(idTokenEntity.getUserName());
        return token;
    }
}
