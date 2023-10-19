package com.bapi.auth.backend.api;

import com.bapi.auth.backend.service.ServiceApi;
import com.bapi.auth.backend.service.base.BaseResponse;
import com.bapi.auth.backend.service.base.ResponseStatus;
import com.bapi.auth.backend.service.request.LoginRequest;
import com.bapi.auth.backend.service.request.ProfileUpdateRequest;
import com.bapi.auth.backend.service.request.SignupRequest;
import com.bapi.auth.backend.service.response.AuthResponse;
import com.bapi.auth.backend.service.response.ProfileUpdateResponse;
import com.bapi.auth.backend.service.response.SignOutResponse;
import com.bapi.auth.backend.service.response.UserDataResponse;
import com.bapi.platform.header.HeaderParams;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseAuthentication {
    @Autowired
    private ServiceApi serviceApi;

    protected BaseResponse<?> doLogin(HeaderParams headerParams, LoginRequest loginRequest) {
        try {
            AuthResponse authResponse = serviceApi.authService().login(loginRequest, headerParams);
            return new BaseResponse<>(ResponseStatus.success(), authResponse);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> doSignup(HeaderParams headerParams, SignupRequest signupRequest) {
        try {
            AuthResponse authResponse = serviceApi.authService().signup(signupRequest, headerParams);
            return new BaseResponse<>(ResponseStatus.success(), authResponse);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> doUpdate(HeaderParams headerParams, ProfileUpdateRequest profileUpdateRequest) {
        try {
            ProfileUpdateResponse profileUpdateResponse = serviceApi.authService().update(profileUpdateRequest, headerParams);
            return new BaseResponse<>(ResponseStatus.success(), profileUpdateResponse);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> getUserDetails(HeaderParams headerParams) {
        try {
            UserDataResponse userDataResponse = serviceApi.authService().getUserDetails(headerParams);
            return new BaseResponse<>(ResponseStatus.success(), userDataResponse);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> doLogout(HeaderParams headerParams) {
        try {
            serviceApi.authService().logout(headerParams);
            return new BaseResponse<>(ResponseStatus.success(), SignOutResponse.builder()
                    .success(true)
                    .build());
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }
}
