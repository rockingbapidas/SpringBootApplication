package com.bapi.springbackend.response;

public class ResponseStatus {
    private Boolean success;
    private int code;
    private String message;

    public ResponseStatus(Boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResponseStatus success() {
        return new ResponseStatus(true, 200, "");
    }

    public static ResponseStatus error() {
        return new ResponseStatus(false, 403, "Something went wrong");
    }

    public static ResponseStatus error(String message) {
        return new ResponseStatus(false, 403, message);
    }
}
