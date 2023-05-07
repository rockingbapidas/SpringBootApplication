package com.bapi.springbackend.response.mapper;

import com.bapi.springbackend.domain.Token;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.response.TokenResponse;
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
}
