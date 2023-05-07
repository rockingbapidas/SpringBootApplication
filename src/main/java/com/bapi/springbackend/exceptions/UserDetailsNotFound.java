package com.bapi.springbackend.exceptions;

public class UserDetailsNotFound extends Throwable {
    public UserDetailsNotFound() {
        super("User details not found or null");
    }

    public UserDetailsNotFound(String message) {
        super(message);
    }

    public UserDetailsNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDetailsNotFound(Throwable cause) {
        super(cause);
    }

    public UserDetailsNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
