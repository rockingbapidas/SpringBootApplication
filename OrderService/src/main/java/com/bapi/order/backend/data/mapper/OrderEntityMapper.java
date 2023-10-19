package com.bapi.order.backend.data.mapper;

import com.bapi.order.backend.data.entity.OrderEntity;
import com.bapi.order.backend.domain.IMapper;
import com.bapi.order.backend.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityMapper implements IMapper<Order, OrderEntity> {
    @Override
    public OrderEntity mapFrom(Order order) {
        return OrderEntity.builder()
                .createdAt(order.getCreatedAt())
                .build();
    }

    @Override
    public Order mapTo(OrderEntity orderEntity) {
        return Order.builder()
                .orderId(orderEntity.getId())
                .createdAt(orderEntity.getCreatedAt())
                .build();
    }
}
