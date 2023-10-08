package com.bapi.service.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenResponse {
    private Long expiry;
    private String userToken;
    private String tokenType;
}
