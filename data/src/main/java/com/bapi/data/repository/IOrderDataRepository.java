package com.bapi.data.repository;

import com.bapi.data.repository.base.IRepository;
import com.bapi.domain.OrderItem;

import java.util.List;

public interface IOrderDataRepository extends IRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId);

    List<OrderItem> saveAll(Long orderId, List<OrderItem> orderItems);

    OrderItem saveByOrderId(Long orderId, OrderItem orderItems);
}
