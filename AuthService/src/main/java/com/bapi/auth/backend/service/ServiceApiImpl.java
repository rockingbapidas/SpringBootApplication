package com.bapi.auth.backend.service;

import com.bapi.auth.backend.service.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceApiImpl implements ServiceApi {

    @Autowired
    private AuthService authService;

    @Override
    public AuthService authService() {
        return authService;
    }
}
