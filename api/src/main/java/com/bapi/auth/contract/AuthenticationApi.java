package com.bapi.auth.contract;

import com.bapi.service.base.BaseResponse;
import com.bapi.service.request.LoginRequest;
import com.bapi.service.request.ProfileUpdateRequest;
import com.bapi.service.request.SignupRequest;

/**
 * Authentication Contract Api
 */
public interface AuthenticationApi {
    /**
     * @param signupRequest is contained sign up user data
     * @return BaseResponse<AuthResponse>
     */
    BaseResponse<?> signup(SignupRequest signupRequest);

    /**
     * @param loginRequest is contained user login credential
     * @return BaseResponse<AuthResponse>
     */
    BaseResponse<?> login(LoginRequest loginRequest);

    /**
     * @param profileUpdateRequest is contained user update information
     * @return BaseResponse<>
     */
    BaseResponse<?> update(ProfileUpdateRequest profileUpdateRequest);

    /**
     * @return BaseResponse<>
     */
    BaseResponse<?> userDetails();

    /**
     * @return BaseResponse<>
     */
    BaseResponse<?> logout();
}
