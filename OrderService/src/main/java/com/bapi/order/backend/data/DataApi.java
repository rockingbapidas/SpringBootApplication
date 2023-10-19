package com.bapi.order.backend.data;

import com.bapi.order.backend.data.repository.IOrderDataRepository;
import com.bapi.order.backend.data.repository.IOrderRepository;
import com.bapi.platform.PlatformApi;

public interface DataApi extends PlatformApi {
    IOrderRepository orderRepository();

    IOrderDataRepository orderDataRepository();
}
