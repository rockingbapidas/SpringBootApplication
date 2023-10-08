package com.bapi.data.repository;

import com.bapi.data.repository.base.IRepository;
import com.bapi.domain.OrderItem;

import java.util.List;

public interface IOrderDataRepository extends IRepository<OrderItem, String> {
    List<OrderItem> findByOrderId(String orderId);

    List<OrderItem> saveAll(String orderId, List<OrderItem> orderItems);

    OrderItem saveByOrderId(String orderId, OrderItem orderItems);
}
