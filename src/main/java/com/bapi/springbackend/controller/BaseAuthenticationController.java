package com.bapi.springbackend.controller;

import com.bapi.springbackend.auth.header.HeaderParams;
import com.bapi.springbackend.request.LoginRequest;
import com.bapi.springbackend.request.ProfileUpdateRequest;
import com.bapi.springbackend.request.SignupRequest;
import com.bapi.springbackend.response.*;
import com.bapi.springbackend.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseAuthenticationController {
    @Autowired
    private IAuthService authService;

    protected BaseResponse<?> doLogin(HeaderParams headerParams, LoginRequest loginRequest) {
        try {
            AuthResponse authResponse = authService.login(loginRequest, headerParams);
            return new BaseResponse<>(ResponseStatus.success(), authResponse);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> doSignup(HeaderParams headerParams, SignupRequest signupRequest) {
        try {
            AuthResponse authResponse = authService.signup(signupRequest, headerParams);
            return new BaseResponse<>(ResponseStatus.success(), authResponse);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> doUpdate(HeaderParams headerParams, ProfileUpdateRequest profileUpdateRequest) {
        try {
            ProfileUpdateResponse profileUpdateResponse = authService.update(profileUpdateRequest, headerParams);
            return new BaseResponse<>(ResponseStatus.success(), profileUpdateResponse);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> getUserDetails(HeaderParams headerParams) {
        try {
            UserDataResponse userDataResponse = authService.getUserDetails(headerParams);
            return new BaseResponse<>(ResponseStatus.success(), userDataResponse);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> doLogout(HeaderParams headerParams) {
        try {
            authService.logout(headerParams);
            return new BaseResponse<>(ResponseStatus.success(), new SignOutResponse(true));
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }
}
