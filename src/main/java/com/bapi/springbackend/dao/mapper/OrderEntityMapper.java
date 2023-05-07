package com.bapi.springbackend.dao.mapper;

import com.bapi.springbackend.dao.OrderEntity;
import com.bapi.springbackend.domain.Order;
import com.bapi.springbackend.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityMapper implements IMapper<Order, OrderEntity> {
    @Override
    public OrderEntity mapFrom(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCreatedAt(order.getCreatedAt());
        return orderEntity;
    }
}
