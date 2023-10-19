package com.bapi.auth.backend.service.exception;

public class UserInfoNotFound extends Throwable {
    public UserInfoNotFound() {
        super("User info not found or null");
    }

    public UserInfoNotFound(String message) {
        super(message);
    }

    public UserInfoNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInfoNotFound(Throwable cause) {
        super(cause);
    }

    public UserInfoNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
