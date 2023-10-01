package com.bapi.service.response;

public class TokenResponse {
    private Long expiry;
    private String userToken;
    private String tokenType;

    public TokenResponse(Long expiry, String userToken, String tokenType) {
        this.expiry = expiry;
        this.userToken = userToken;
        this.tokenType = tokenType;
    }

    public Long getExpiry() {
        return expiry;
    }

    public void setExpiry(Long expiry) {
        this.expiry = expiry;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
