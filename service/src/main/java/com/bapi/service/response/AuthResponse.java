package com.bapi.service.response;

public class AuthResponse {
    private UserDataResponse userDataResponse;
    private TokenResponse tokenResponse;

    public AuthResponse(UserDataResponse userDataResponse, TokenResponse tokenResponse) {
        this.userDataResponse = userDataResponse;
        this.tokenResponse = tokenResponse;
    }

    public UserDataResponse getUserDetail() {
        return userDataResponse;
    }

    public void setUserDetail(UserDataResponse userDataResponse) {
        this.userDataResponse = userDataResponse;
    }

    public TokenResponse getTokenDetail() {
        return tokenResponse;
    }

    public void setTokenDetail(TokenResponse tokenResponse) {
        this.tokenResponse = tokenResponse;
    }
}
