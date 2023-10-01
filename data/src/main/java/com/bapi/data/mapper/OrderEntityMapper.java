package com.bapi.data.mapper;

import com.bapi.data.entity.OrderEntity;
import com.bapi.domain.IMapper;
import com.bapi.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityMapper implements IMapper<Order, OrderEntity> {
    @Override
    public OrderEntity mapFrom(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCreatedAt(order.getCreatedAt());
        return orderEntity;
    }

    @Override
    public Order mapTo(OrderEntity orderEntity) {
        return new Order(orderEntity.getOrderId(), orderEntity.getCreatedAt());
    }
}
