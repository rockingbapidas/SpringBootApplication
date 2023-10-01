package com.bapi.auth.authorization.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class UserDetailsNotFound extends BadCredentialsException {
    public UserDetailsNotFound() {
        super("User details not found or null");
    }

    public UserDetailsNotFound(String message) {
        super(message);
    }

    public UserDetailsNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
