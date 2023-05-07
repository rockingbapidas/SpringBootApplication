package com.bapi.springbackend.dao.mapper;

import com.bapi.springbackend.dao.OrderItemEntity;
import com.bapi.springbackend.domain.OrderItem;
import com.bapi.springbackend.mapper.IMapper;
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
}
