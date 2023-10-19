package com.bapi.auth.backend.api;


import com.bapi.auth.backend.service.base.BaseResponse;
import com.bapi.auth.backend.service.request.LoginRequest;
import com.bapi.auth.backend.service.request.ProfileUpdateRequest;
import com.bapi.auth.backend.service.request.SignupRequest;

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
