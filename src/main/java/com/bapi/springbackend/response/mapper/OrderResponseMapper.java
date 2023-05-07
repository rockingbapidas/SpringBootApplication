package com.bapi.springbackend.response.mapper;

import com.bapi.springbackend.domain.Order;
import com.bapi.springbackend.domain.OrderItem;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.response.OrderItemResponse;
import com.bapi.springbackend.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class OrderResponseMapper implements IMapper<Order, OrderResponse> {
    @Autowired
    private IMapper<OrderItem, OrderItemResponse> orderItemResponseMapper;

    @Override
    public OrderResponse mapFrom(Order order) {
        List<OrderItemResponse> orderItemResponseList = new ArrayList<>();
        if (order.getOrderItems() != null) {
            orderItemResponseList = order.getOrderItems()
                    .stream()
                    .map(orderItemResponseMapper::mapFrom)
                    .collect(Collectors.toList());
        }
        return new OrderResponse(order.getOrderId(), order.getCreatedAt(), orderItemResponseList);
    }
}
