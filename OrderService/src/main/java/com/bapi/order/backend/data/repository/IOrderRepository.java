package com.bapi.order.backend.data.repository;

import com.bapi.order.backend.data.repository.base.IRepository;
import com.bapi.order.backend.domain.Order;

import java.util.List;

public interface IOrderRepository extends IRepository<Order, String> {
    List<Order> findAllByUserId(Long userId);

    Order saveByUserId(Long userId, Order order);
}
