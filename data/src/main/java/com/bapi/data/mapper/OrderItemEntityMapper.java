package com.bapi.data.mapper;

import com.bapi.data.entity.OrderItemEntity;
import com.bapi.domain.IMapper;
import com.bapi.domain.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemEntityMapper implements IMapper<OrderItem, OrderItemEntity> {
    @Override
    public OrderItemEntity mapFrom(OrderItem orderItem) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setItem(orderItem.getItem());
        orderItemEntity.setAmount(orderItem.getAmount());
        orderItemEntity.setPrice(orderItem.getPrice());
        return orderItemEntity;
    }

    @Override
    public OrderItem mapTo(OrderItemEntity orderItemEntity) {
        return new OrderItem(
                orderItemEntity.getId(),
                orderItemEntity.getItem(),
                orderItemEntity.getAmount(),
                orderItemEntity.getPrice()
        );
    }
}
