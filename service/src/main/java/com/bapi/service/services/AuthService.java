package com.bapi.service.services;


import com.bapi.platform.header.HeaderParams;
import com.bapi.service.request.LoginRequest;
import com.bapi.service.request.ProfileUpdateRequest;
import com.bapi.service.request.SignupRequest;
import com.bapi.service.response.AuthResponse;
import com.bapi.service.response.ProfileUpdateResponse;
import com.bapi.service.response.UserDataResponse;

public interface AuthService {
    AuthResponse signup(SignupRequest signupRequest, HeaderParams headerParams) throws Throwable;

    ProfileUpdateResponse update(ProfileUpdateRequest profileUpdateRequest, HeaderParams headerParams) throws Throwable;

    AuthResponse login(LoginRequest loginRequest, HeaderParams headerParams) throws Throwable;

    UserDataResponse getUserDetails(HeaderParams headerParams) throws Throwable;

    void logout(HeaderParams headerParams) throws Throwable;
}
