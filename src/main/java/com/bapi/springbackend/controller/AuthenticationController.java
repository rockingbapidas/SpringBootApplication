package com.bapi.springbackend.controller;

import com.bapi.springbackend.auth.header.HeaderParams;
import com.bapi.springbackend.auth.header.HeaderUtils;
import com.bapi.springbackend.request.LoginRequest;
import com.bapi.springbackend.request.ProfileUpdateRequest;
import com.bapi.springbackend.request.SignupRequest;
import com.bapi.springbackend.response.AuthResponse;
import com.bapi.springbackend.response.BaseResponse;
import com.bapi.springbackend.response.ProfileUpdateResponse;
import com.bapi.springbackend.response.ResponseStatus;
import com.bapi.springbackend.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.Logger;

@RestController
public class AuthenticationController {
    private final String TAG = AuthenticationController.class.getSimpleName();
    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    @ResponseBody
    public BaseResponse<?> login(@RequestHeader Map<String, String> headers, @RequestBody LoginRequest loginRequest) {
        Logger.getLogger(TAG).info("Login user account ===== " + headers + " " + loginRequest);
        try {
            HeaderParams headerParams = HeaderParams.builder().setHeaders(headers).build();
            AuthResponse authResponse = authService.login(loginRequest, headerParams);
            return new BaseResponse<>(ResponseStatus.success(), authResponse);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    @PostMapping("/signup")
    @ResponseBody
    public BaseResponse<?> signup(@RequestHeader Map<String, String> headers, @RequestBody SignupRequest signupRequest) {
        Logger.getLogger(TAG).info("Create user account ===== " + headers + " " + signupRequest);
        try {
            AuthResponse authResponse = authService.signup(signupRequest, HeaderParams.builder().setHeaders(headers).build());
            return new BaseResponse<>(ResponseStatus.success(), authResponse);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public BaseResponse<?> update(@RequestHeader Map<String, String> headers, @RequestBody ProfileUpdateRequest profileUpdateRequest) {
        Logger.getLogger(TAG).info("Update user profile ===== " + headers + " " + profileUpdateRequest);
        try {
            ProfileUpdateResponse profileUpdateResponse = authService.update(profileUpdateRequest, HeaderParams.builder().setHeaders(headers).build());
            return new BaseResponse<>(ResponseStatus.success(), profileUpdateResponse);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    @GetMapping("/logout")
    @ResponseBody
    public BaseResponse<?> logout(@RequestHeader Map<String, String> headers) {
        Logger.getLogger(TAG).info("Logout user account ===== " + headers);
        try {
            authService.logout(HeaderParams.builder().setHeaders(headers).build());
            return new BaseResponse<>(ResponseStatus.success(), null);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }
}
