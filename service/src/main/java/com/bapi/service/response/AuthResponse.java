package com.bapi.service.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {
    private UserDataResponse userDataResponse;
    private TokenResponse tokenResponse;
}
