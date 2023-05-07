package com.bapi.springbackend.repository;

import com.bapi.springbackend.domain.Order;

import java.util.List;

public interface IOrderRepository extends IRepository<Order, Long> {
    Order saveByUserId(Long userId, Order order);
    List<Order> findAllByUserId(Long userId);
}
