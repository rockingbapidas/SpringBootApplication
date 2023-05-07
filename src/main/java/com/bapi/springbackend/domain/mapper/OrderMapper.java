package com.bapi.springbackend.domain.mapper;

import com.bapi.springbackend.dao.OrderEntity;
import com.bapi.springbackend.domain.Order;
import com.bapi.springbackend.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements IMapper<OrderEntity, Order> {
    @Override
    public Order mapFrom(OrderEntity orderEntity) {
        Order order = new Order();
        order.setOrderId(orderEntity.getOrderId());
        order.setCreatedAt(orderEntity.getCreatedAt());
        return order;
    }
}
