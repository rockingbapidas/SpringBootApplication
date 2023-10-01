package com.bapi.service.response.mapper;

import com.bapi.domain.IMapper;
import com.bapi.domain.Order;
import com.bapi.service.response.OrderItemResponse;
import com.bapi.service.response.OrderResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderResponseMapper implements IMapper<Order, OrderResponse> {

    @Override
    public OrderResponse mapFrom(Order order) {
        List<OrderItemResponse> orderItemResponseList = new ArrayList<>();
        if (order.getOrderItems() != null) {
            orderItemResponseList = order.getOrderItems()
                    .stream()
                    .map(orderItem -> new OrderItemResponse(orderItem.getItem(),
                            orderItem.getAmount(),
                            orderItem.getPrice()))
                    .collect(Collectors.toList());
        }
        return new OrderResponse(order.getOrderId(), order.getCreatedAt(), orderItemResponseList);
    }

    @Override
    public Order mapTo(OrderResponse orderResponse) {
        return null;
    }
}
