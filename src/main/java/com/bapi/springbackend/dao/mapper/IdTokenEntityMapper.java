package com.bapi.springbackend.dao.mapper;

import com.bapi.springbackend.dao.IdTokenEntity;
import com.bapi.springbackend.domain.Token;
import com.bapi.springbackend.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class IdTokenEntityMapper implements IMapper<Token, IdTokenEntity> {
    @Override
    public IdTokenEntity mapFrom(Token token) {
        IdTokenEntity idTokenEntity = new IdTokenEntity();
        idTokenEntity.setDeviceUniqueId(token.getDeviceUniqueId());
        idTokenEntity.setDeviceType(token.getDeviceType());
        idTokenEntity.setAccessToken(token.getAccessToken());
        idTokenEntity.setTokenType(token.getTokenType());
        idTokenEntity.setExpiresAt(token.getExpiresAt());
        idTokenEntity.setUserName(token.getUserName());
        return idTokenEntity;
    }
}
