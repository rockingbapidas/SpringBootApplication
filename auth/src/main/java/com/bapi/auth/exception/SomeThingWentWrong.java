package com.bapi.auth.exception;

public class SomeThingWentWrong extends Throwable {
    public SomeThingWentWrong() {
        super("Some thing went wrong");
    }

    public SomeThingWentWrong(String message) {
        super(message);
    }

    public SomeThingWentWrong(String message, Throwable cause) {
        super(message, cause);
    }

    public SomeThingWentWrong(Throwable cause) {
        super(cause);
    }

    public SomeThingWentWrong(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
