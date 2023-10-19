package com.bapi.order.backend.data.repository;


import com.bapi.order.backend.data.repository.base.IRepository;
import com.bapi.order.backend.domain.OrderItem;

import java.util.List;

public interface IOrderDataRepository extends IRepository<OrderItem, String> {
    List<OrderItem> findByOrderId(String orderId);

    List<OrderItem> saveAll(String orderId, List<OrderItem> orderItems);

    OrderItem saveByOrderId(String orderId, OrderItem orderItems);
}
