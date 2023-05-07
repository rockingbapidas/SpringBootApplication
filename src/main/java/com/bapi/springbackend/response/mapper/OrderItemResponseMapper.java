package com.bapi.springbackend.response.mapper;

import com.bapi.springbackend.domain.OrderItem;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.response.OrderItemResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderItemResponseMapper implements IMapper<OrderItem, OrderItemResponse> {
    @Override
    public OrderItemResponse mapFrom(OrderItem orderItem) {
        return new OrderItemResponse(orderItem.getItem(),
                orderItem.getAmount(),
                orderItem.getPrice());
    }
}
