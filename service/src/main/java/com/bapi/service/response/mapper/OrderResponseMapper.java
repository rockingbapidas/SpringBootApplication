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
                    .map(orderItem -> OrderItemResponse.builder()
                            .item(orderItem.getItem())
                            .amount(orderItem.getAmount())
                            .price(orderItem.getPrice())
                            .build())
                    .collect(Collectors.toList());
        }
        return OrderResponse.builder()
                .orderId(order.getOrderId())
                .contents(orderItemResponseList)
                .createdAt(order.getCreatedAt())
                .build();
    }

    @Override
    public Order mapTo(OrderResponse orderResponse) {
        return null;
    }
}
