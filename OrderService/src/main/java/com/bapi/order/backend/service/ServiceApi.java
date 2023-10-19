package com.bapi.order.backend.service;

import com.bapi.order.backend.service.services.OrderService;
import com.bapi.platform.PlatformApi;

public interface ServiceApi extends PlatformApi {
    OrderService orderService();
}
