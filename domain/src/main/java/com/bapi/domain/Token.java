package com.bapi.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Token {
    private String deviceUniqueId;
    private String deviceType;
    private Long expiresAt;
    private String accessToken;
    private String tokenType;
    private String userName;
}
