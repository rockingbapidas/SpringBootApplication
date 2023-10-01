package com.bapi.service;

import com.bapi.platform.PlatformApi;
import com.bapi.service.services.AuthService;
import com.bapi.service.services.OrderService;

public interface ServiceApi extends PlatformApi {
    AuthService authService();

    OrderService orderService();
}
