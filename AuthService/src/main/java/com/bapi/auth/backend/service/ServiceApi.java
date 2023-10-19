package com.bapi.auth.backend.service;

import com.bapi.auth.backend.service.services.AuthService;
import com.bapi.platform.PlatformApi;

public interface ServiceApi extends PlatformApi {
    AuthService authService();
}
