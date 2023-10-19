package com.bapi.auth.backend.data.mapper;

import com.bapi.auth.backend.data.entity.IdTokenEntity;
import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.Token;
import org.springframework.stereotype.Component;

@Component
public class IdTokenEntityMapper implements IMapper<Token, IdTokenEntity> {
    @Override
    public IdTokenEntity mapFrom(Token token) {
        return IdTokenEntity.builder()
                .deviceUniqueId(token.getDeviceUniqueId())
                .deviceType(token.getDeviceType())
                .accessToken(token.getAccessToken())
                .tokenType(token.getTokenType())
                .expiresAt(token.getExpiresAt())
                .userName(token.getUserName())
                .build();
    }

    @Override
    public Token mapTo(IdTokenEntity idTokenEntity) {
        return Token.builder()
                .deviceUniqueId(idTokenEntity.getDeviceUniqueId())
                .deviceType(idTokenEntity.getDeviceType())
                .expiresAt(idTokenEntity.getExpiresAt())
                .accessToken(idTokenEntity.getAccessToken())
                .tokenType(idTokenEntity.getTokenType())
                .userName(idTokenEntity.getUserName())
                .build();
    }
}
