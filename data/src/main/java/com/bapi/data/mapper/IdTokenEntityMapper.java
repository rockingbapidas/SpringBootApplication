package com.bapi.data.mapper;

import com.bapi.data.entity.IdTokenEntity;
import com.bapi.domain.IMapper;
import com.bapi.domain.Token;
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

    @Override
    public Token mapTo(IdTokenEntity idTokenEntity) {
        return new Token(
                idTokenEntity.getDeviceUniqueId(),
                idTokenEntity.getDeviceType(),
                idTokenEntity.getExpiresAt(),
                idTokenEntity.getAccessToken(),
                idTokenEntity.getTokenType(),
                idTokenEntity.getUserName()
        );
    }
}
