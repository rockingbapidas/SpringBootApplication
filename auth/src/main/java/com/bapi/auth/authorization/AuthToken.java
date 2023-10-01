package com.bapi.auth.authorization;

public class AuthToken {
    private final String deviceUniqueId;
    private final String deviceType;
    private final Long expiryTime;
    private final String accessToken;
    private final String tokenType;
    private final String userName;

    public AuthToken(String deviceUniqueId, String deviceType, Long expiryTime, String accessToken, String tokenType, String userName) {
        this.deviceUniqueId = deviceUniqueId;
        this.deviceType = deviceType;
        this.expiryTime = expiryTime;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.userName = userName;
    }

    public String getDeviceUniqueId() {
        return deviceUniqueId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public Long getExpiryTime() {
        return expiryTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getUserName() {
        return userName;
    }

    public static AuthTokenBuilder builder() {
        return new AuthTokenBuilder();
    }

    public static class AuthTokenBuilder {
        private String deviceUniqueId;
        private String deviceType;
        private Long expiryTime;
        private String accessToken;
        private String tokenType;
        private String userName;

        public AuthTokenBuilder() {
        }

        public AuthTokenBuilder setDeviceUniqueId(String deviceUniqueId) {
            this.deviceUniqueId = deviceUniqueId;
            return this;
        }

        public AuthTokenBuilder setDeviceType(String deviceType) {
            this.deviceType = deviceType;
            return this;
        }

        public AuthTokenBuilder setExpiryTime(Long expiryTime) {
            this.expiryTime = expiryTime;
            return this;
        }

        public AuthTokenBuilder setAccessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public AuthTokenBuilder setTokenType(String tokenType) {
            this.tokenType = tokenType;
            return this;
        }

        public AuthTokenBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public AuthToken build() {
            return new AuthToken(deviceUniqueId, deviceType, expiryTime, accessToken, tokenType, userName);
        }
    }
}
