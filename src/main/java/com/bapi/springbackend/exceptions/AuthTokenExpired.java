package com.bapi.springbackend.exceptions;

public class AuthTokenExpired extends Throwable {
    public AuthTokenExpired() {
        super("Authorization Token expired. Please sign in again.");
    }

    public AuthTokenExpired(String message) {
        super(message);
    }

    public AuthTokenExpired(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthTokenExpired(Throwable cause) {
        super(cause);
    }

    public AuthTokenExpired(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
