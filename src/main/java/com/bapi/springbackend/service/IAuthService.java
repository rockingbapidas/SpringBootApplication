package com.bapi.springbackend.service;

import com.bapi.springbackend.auth.header.HeaderParams;
import com.bapi.springbackend.request.LoginRequest;
import com.bapi.springbackend.request.ProfileUpdateRequest;
import com.bapi.springbackend.request.SignupRequest;
import com.bapi.springbackend.response.AuthResponse;
import com.bapi.springbackend.response.ProfileUpdateResponse;

public interface IAuthService {
    AuthResponse signup(SignupRequest signupRequest, HeaderParams build) throws Throwable;

    ProfileUpdateResponse update(ProfileUpdateRequest profileUpdateRequest, HeaderParams build) throws Throwable;

    AuthResponse login(LoginRequest loginRequest, HeaderParams build) throws Throwable;

    void logout(HeaderParams build) throws Throwable;
}
