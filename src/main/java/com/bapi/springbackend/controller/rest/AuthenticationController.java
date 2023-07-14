package com.bapi.springbackend.controller.rest;

import com.bapi.springbackend.auth.header.HeaderParams;
import com.bapi.springbackend.controller.BaseAuthenticationController;
import com.bapi.springbackend.request.LoginRequest;
import com.bapi.springbackend.request.ProfileUpdateRequest;
import com.bapi.springbackend.request.SignupRequest;
import com.bapi.springbackend.response.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.Logger;

@RestController
public class AuthenticationController extends BaseAuthenticationController {
    private final String TAG = AuthenticationController.class.getSimpleName();

    @PostMapping("/login")
    @ResponseBody
    public BaseResponse<?> login(@RequestHeader Map<String, String> headers, @RequestBody LoginRequest loginRequest) {
        Logger.getLogger(TAG).info("Login user account ===== " + headers + " " + loginRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(headers).build();
        return doLogin(headerParams, loginRequest);
    }

    @PostMapping("/signup")
    @ResponseBody
    public BaseResponse<?> signup(@RequestHeader Map<String, String> headers, @RequestBody SignupRequest signupRequest) {
        Logger.getLogger(TAG).info("Create user account ===== " + headers + " " + signupRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(headers).build();
        return doSignup(headerParams, signupRequest);
    }

    @PostMapping("/update")
    @ResponseBody
    public BaseResponse<?> update(@RequestHeader Map<String, String> headers, @RequestBody ProfileUpdateRequest profileUpdateRequest) {
        Logger.getLogger(TAG).info("Update user profile ===== " + headers + " " + profileUpdateRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(headers).build();
        return doUpdate(headerParams, profileUpdateRequest);
    }

    @GetMapping("/getUserDetails")
    @ResponseBody
    public BaseResponse<?> userDetails(@RequestHeader Map<String, String> headers) {
        Logger.getLogger(TAG).info("Get user details ===== " + headers);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(headers).build();
        return getUserDetails(headerParams);
    }

    @GetMapping("/logout")
    @ResponseBody
    public BaseResponse<?> logout(@RequestHeader Map<String, String> headers) {
        Logger.getLogger(TAG).info("Logout user account ===== " + headers);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(headers).build();
        return doLogout(headerParams);
    }
}
