package com.bapi.order.backend.service;

import com.bapi.order.backend.service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceApiImpl implements ServiceApi {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderService orderService() {
        return orderService;
    }
}
