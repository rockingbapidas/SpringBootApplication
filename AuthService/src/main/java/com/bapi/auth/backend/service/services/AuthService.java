package com.bapi.auth.backend.service.services;


import com.bapi.auth.backend.service.request.LoginRequest;
import com.bapi.auth.backend.service.request.ProfileUpdateRequest;
import com.bapi.auth.backend.service.request.SignupRequest;
import com.bapi.auth.backend.service.response.AuthResponse;
import com.bapi.auth.backend.service.response.ProfileUpdateResponse;
import com.bapi.auth.backend.service.response.UserDataResponse;
import com.bapi.platform.header.HeaderParams;

public interface AuthService {
    AuthResponse signup(SignupRequest signupRequest, HeaderParams headerParams) throws Throwable;

    ProfileUpdateResponse update(ProfileUpdateRequest profileUpdateRequest, HeaderParams headerParams) throws Throwable;

    AuthResponse login(LoginRequest loginRequest, HeaderParams headerParams) throws Throwable;

    UserDataResponse getUserDetails(HeaderParams headerParams) throws Throwable;

    void logout(HeaderParams headerParams) throws Throwable;
}
