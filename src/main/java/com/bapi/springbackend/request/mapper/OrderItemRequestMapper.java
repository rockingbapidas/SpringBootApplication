package com.bapi.springbackend.request.mapper;

import com.bapi.springbackend.domain.OrderItem;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.request.OrderItemRequest;
import com.bapi.springbackend.request.PlaceOrderRequest;
import org.springframework.stereotype.Component;

@Component
public class OrderItemRequestMapper implements IMapper<OrderItemRequest, OrderItem> {

    @Override
    public OrderItem mapFrom(OrderItemRequest item) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item.getName());
        orderItem.setAmount(item.getAmount());
        orderItem.setPrice(item.getPrice());
        return orderItem;
    }
}
