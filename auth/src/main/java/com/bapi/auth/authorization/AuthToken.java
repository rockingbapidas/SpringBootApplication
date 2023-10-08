package com.bapi.auth.authorization;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthToken {
    private String deviceUniqueId;
    private String deviceType;
    private Long expiryTime;
    private String accessToken;
    private String tokenType;
    private String userName;
}
