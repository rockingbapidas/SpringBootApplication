package com.bapi.auth.gql;

import com.bapi.auth.base.BaseAuthentication;
import com.bapi.auth.contract.AuthenticationApi;
import com.bapi.platform.header.HeaderParams;
import com.bapi.service.base.BaseResponse;
import com.bapi.service.request.LoginRequest;
import com.bapi.service.request.ProfileUpdateRequest;
import com.bapi.service.request.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class AuthenticationGraphImpl extends BaseAuthentication implements AuthenticationApi {
    private final String TAG = AuthenticationGraphImpl.class.getSimpleName();
    @Autowired
    private HttpServletRequest httpServletRequest;

    @MutationMapping("createAccount")
    @PreAuthorize("isAnonymous()")
    @Override
    public BaseResponse<?> signup(@Argument SignupRequest signupRequest) {
        Logger.getLogger(TAG).info("Create user account ===== " + signupRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return doSignup(headerParams, signupRequest);
    }

    @QueryMapping("signIn")
    @PreAuthorize("isAnonymous()")
    @Override
    public BaseResponse<?> login(@Argument LoginRequest loginRequest) {
        Logger.getLogger(TAG).info("Login user account ===== " + loginRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return doLogin(headerParams, loginRequest);
    }

    @MutationMapping("updateUser")
    @PreAuthorize("isAuthenticated()")
    @Override
    public BaseResponse<?> update(@Argument ProfileUpdateRequest profileUpdateRequest) {
        Logger.getLogger(TAG).info("Update user profile ===== " + profileUpdateRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return doUpdate(headerParams, profileUpdateRequest);
    }

    @QueryMapping("getUserDetails")
    @PreAuthorize("isAuthenticated()")
    @Override
    public BaseResponse<?> userDetails() {
        Logger.getLogger(TAG).info("Get user details ===== ");
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return getUserDetails(headerParams);
    }

    @QueryMapping("signOut")
    @PreAuthorize("isAuthenticated()")
    @Override
    public BaseResponse<?> logout() {
        Logger.getLogger(TAG).info("Logout user account ===== ");
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return doLogout(headerParams);
    }
}
