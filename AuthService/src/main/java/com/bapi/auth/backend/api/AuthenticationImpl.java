package com.bapi.auth.backend.api;

import com.bapi.auth.backend.service.base.BaseResponse;
import com.bapi.auth.backend.service.request.LoginRequest;
import com.bapi.auth.backend.service.request.ProfileUpdateRequest;
import com.bapi.auth.backend.service.request.SignupRequest;
import com.bapi.platform.header.HeaderParams;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class AuthenticationImpl extends BaseAuthentication implements AuthenticationApi {

    private final String TAG = AuthenticationImpl.class.getSimpleName();
    @Autowired
    private HttpServletRequest httpServletRequest;

    @PostMapping("/signup")
    @ResponseBody
    @Override
    public BaseResponse<?> signup(@RequestBody SignupRequest signupRequest) {
        Logger.getLogger(TAG).info("Create user account ===== " + signupRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return doSignup(headerParams, signupRequest);
    }

    @PostMapping("/login")
    @ResponseBody
    @Override
    public BaseResponse<?> login(@RequestBody LoginRequest loginRequest) {
        Logger.getLogger(TAG).info("Login user account ===== " + loginRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return doLogin(headerParams, loginRequest);
    }

    @PostMapping("/update")
    @ResponseBody
    @Override
    public BaseResponse<?> update(@RequestBody ProfileUpdateRequest profileUpdateRequest) {
        Logger.getLogger(TAG).info("Update user profile ===== " + profileUpdateRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return doUpdate(headerParams, profileUpdateRequest);
    }

    @GetMapping("/getUserDetails")
    @ResponseBody
    @Override
    public BaseResponse<?> userDetails() {
        Logger.getLogger(TAG).info("Get user details ===== ");
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return getUserDetails(headerParams);
    }

    @GetMapping("/logout")
    @ResponseBody
    @Override
    public BaseResponse<?> logout() {
        Logger.getLogger(TAG).info("Logout user account ===== ");
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return doLogout(headerParams);
    }
}
