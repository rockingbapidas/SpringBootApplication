package com.bapi.order.backend.data.mapper;

import com.bapi.order.backend.data.entity.OrderItemEntity;
import com.bapi.order.backend.domain.IMapper;
import com.bapi.order.backend.domain.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemEntityMapper implements IMapper<OrderItem, OrderItemEntity> {
    @Override
    public OrderItemEntity mapFrom(OrderItem orderItem) {
        return OrderItemEntity.builder()
                .item(orderItem.getItem())
                .amount(orderItem.getAmount())
                .price(orderItem.getPrice())
                .build();
    }

    @Override
    public OrderItem mapTo(OrderItemEntity orderItemEntity) {
        return OrderItem.builder()
                .id(orderItemEntity.getId())
                .item(orderItemEntity.getItem())
                .amount(orderItemEntity.getAmount())
                .price(orderItemEntity.getPrice())
                .build();
    }
}
