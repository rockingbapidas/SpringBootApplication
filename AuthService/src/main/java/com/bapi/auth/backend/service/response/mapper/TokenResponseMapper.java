package com.bapi.auth.backend.service.response.mapper;

import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.Token;
import com.bapi.auth.backend.service.response.TokenResponse;
import org.springframework.stereotype.Component;

@Component
public class TokenResponseMapper implements IMapper<Token, TokenResponse> {
    @Override
    public TokenResponse mapFrom(Token token) {
        return TokenResponse.builder()
                .expiry(token.getExpiresAt())
                .tokenType(token.getTokenType())
                .userToken(token.getAccessToken())
                .build();
    }

    @Override
    public Token mapTo(TokenResponse tokenResponse) {
        return null;
    }
}
