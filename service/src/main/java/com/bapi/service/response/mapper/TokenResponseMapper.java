package com.bapi.service.response.mapper;

import com.bapi.domain.IMapper;
import com.bapi.domain.Token;
import com.bapi.service.response.TokenResponse;
import org.springframework.stereotype.Component;

@Component
public class TokenResponseMapper implements IMapper<Token, TokenResponse> {
    @Override
    public TokenResponse mapFrom(Token token) {
        return new TokenResponse(
                token.getExpiresAt(),
                token.getAccessToken(),
                token.getTokenType()
        );
    }

    @Override
    public Token mapTo(TokenResponse tokenResponse) {
        return null;
    }
}
