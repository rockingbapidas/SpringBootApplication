package com.bapi.auth.backend.authorization.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class InvalidCredential extends BadCredentialsException {
    public InvalidCredential() {
        super("Invalid username or password");
    }
}
