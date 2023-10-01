package com.bapi.service;

import com.bapi.service.services.AuthService;
import com.bapi.service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceApiImpl implements ServiceApi {

    @Autowired
    private AuthService authService;

    @Autowired
    private OrderService orderService;

    @Override
    public AuthService authService() {
        return authService;
    }

    @Override
    public OrderService orderService() {
        return orderService;
    }
}
