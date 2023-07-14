package com.bapi.springbackend.controller.graphql;

import com.bapi.springbackend.auth.header.HeaderParams;
import com.bapi.springbackend.controller.BaseAuthenticationController;
import com.bapi.springbackend.request.LoginRequest;
import com.bapi.springbackend.request.ProfileUpdateRequest;
import com.bapi.springbackend.request.SignupRequest;
import com.bapi.springbackend.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class AuthenticationGqlController extends BaseAuthenticationController {
    private final String TAG = AuthenticationGqlController.class.getSimpleName();
    @Autowired
    private HttpServletRequest httpServletRequest;

    @QueryMapping("signIn")
    @PreAuthorize("isAnonymous()")
    public BaseResponse<?> login(@Argument LoginRequest loginRequest) {
        Logger.getLogger(TAG).info("Login user account ===== " + " " + loginRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return doLogin(headerParams, loginRequest);
    }

    @MutationMapping("createAccount")
    @PreAuthorize("isAnonymous()")
    public BaseResponse<?> signup(@Argument SignupRequest signupRequest) {
        Logger.getLogger(TAG).info("Create user account ===== " + " " + signupRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return doSignup(headerParams, signupRequest);
    }

    @MutationMapping("updateUser")
    @PreAuthorize("isAuthenticated()")
    public BaseResponse<?> update(@Argument ProfileUpdateRequest profileUpdateRequest) {
        Logger.getLogger(TAG).info("Update user profile ===== " + " " + profileUpdateRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return doUpdate(headerParams, profileUpdateRequest);
    }

    @QueryMapping("getUserDetails")
    @PreAuthorize("isAuthenticated()")
    public BaseResponse<?> userDetails() {
        Logger.getLogger(TAG).info("Get user details ===== ");
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return getUserDetails(headerParams);
    }

    @QueryMapping("signOut")
    @PreAuthorize("isAuthenticated()")
    public BaseResponse<?> logout() {
        Logger.getLogger(TAG).info("Logout user account ===== ");
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return doLogout(headerParams);
    }
}
