package com.bapi.springbackend.domain.mapper;

import com.bapi.springbackend.dao.OrderItemEntity;
import com.bapi.springbackend.domain.OrderItem;
import com.bapi.springbackend.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper implements IMapper<OrderItemEntity, OrderItem> {
    @Override
    public OrderItem mapFrom(OrderItemEntity orderItemEntity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemEntity.getId());
        orderItem.setItem(orderItemEntity.getItem());
        orderItem.setAmount(orderItemEntity.getAmount());
        orderItem.setPrice(orderItemEntity.getPrice());
        return orderItem;
    }
}
