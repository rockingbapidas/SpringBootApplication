package com.bapi.springbackend.response;

public class ProfileUpdateResponse {
    private boolean success;

    public ProfileUpdateResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
