package com.bapi.auth.authorization.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class InvalidCredential extends BadCredentialsException {
    public InvalidCredential() {
        super("Invalid username or password");
    }
}
