package com.bapi.springbackend.exceptions;

public class OrderDetailNotFound extends Throwable {
    public OrderDetailNotFound() {
        super("Order details or data not found");
    }

    public OrderDetailNotFound(String message) {
        super(message);
    }

    public OrderDetailNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderDetailNotFound(Throwable cause) {
        super(cause);
    }

    public OrderDetailNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
