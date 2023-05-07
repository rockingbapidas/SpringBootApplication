package com.bapi.springbackend.exceptions;

import org.springframework.security.authentication.BadCredentialsException;

public class InvalidCredential extends BadCredentialsException {
    public InvalidCredential() {
        super("Invalid username or password");
    }
}
