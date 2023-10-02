package com.bapi.auth.creation.exception;

public class AccountAlreadyExist extends Throwable {
    public AccountAlreadyExist() {
        super("Account already exist");
    }

    public AccountAlreadyExist(String message) {
        super(message);
    }

    public AccountAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountAlreadyExist(Throwable cause) {
        super(cause);
    }

    public AccountAlreadyExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
