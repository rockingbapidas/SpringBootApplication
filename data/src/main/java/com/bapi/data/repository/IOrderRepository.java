package com.bapi.data.repository;

import com.bapi.data.repository.base.IRepository;
import com.bapi.domain.Order;

import java.util.List;

public interface IOrderRepository extends IRepository<Order, Long> {
    List<Order> findAllByUserId(Long userId);

    Order saveByUserId(Long userId, Order order);
}
