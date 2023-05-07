package com.bapi.springbackend.exceptions;

public class AccountDoesNotExist extends Throwable {
    public AccountDoesNotExist() {
        super("Account does not exist");
    }

    public AccountDoesNotExist(String message) {
        super(message);
    }

    public AccountDoesNotExist(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountDoesNotExist(Throwable cause) {
        super(cause);
    }

    public AccountDoesNotExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
