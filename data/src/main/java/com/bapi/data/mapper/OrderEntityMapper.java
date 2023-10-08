package com.bapi.data.mapper;

import com.bapi.data.entity.OrderEntity;
import com.bapi.domain.IMapper;
import com.bapi.domain.Order;
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
