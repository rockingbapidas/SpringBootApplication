package com.bapi.domain;

public class Token {
    private String deviceUniqueId;
    private String deviceType;
    private Long expiresAt;
    private String accessToken;
    private String tokenType;
    private String userName;

    public Token(String deviceUniqueId, String deviceType, Long expiresAt, String accessToken, String tokenType, String userName) {
        this.deviceUniqueId = deviceUniqueId;
        this.deviceType = deviceType;
        this.expiresAt = expiresAt;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.userName = userName;
    }

    public String getDeviceUniqueId() {
        return deviceUniqueId;
    }

    public void setDeviceUniqueId(String deviceUniqueId) {
        this.deviceUniqueId = deviceUniqueId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Long expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
