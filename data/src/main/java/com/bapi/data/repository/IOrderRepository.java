package com.bapi.data.repository;

import com.bapi.data.repository.base.IRepository;
import com.bapi.domain.Order;

import java.util.List;

public interface IOrderRepository extends IRepository<Order, String> {
    List<Order> findAllByUserId(Long userId);

    Order saveByUserId(Long userId, Order order);
}
