package com.bapi.service.response;

public class SignOutResponse {
    private boolean success;

    public SignOutResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
