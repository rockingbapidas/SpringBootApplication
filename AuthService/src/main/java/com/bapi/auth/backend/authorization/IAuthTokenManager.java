package com.bapi.auth.backend.authorization;

public interface IAuthTokenManager {
    AuthToken createToken(String userName, String deviceType, String deviceId) throws Throwable;

    void destroyToken(String userName, String deviceId) throws Throwable;
}
