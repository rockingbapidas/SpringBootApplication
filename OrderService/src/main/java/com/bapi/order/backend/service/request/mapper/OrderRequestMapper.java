package com.bapi.order.backend.service.request.mapper;

import com.bapi.order.backend.domain.IMapper;
import com.bapi.order.backend.domain.Order;
import com.bapi.order.backend.domain.OrderItem;
import com.bapi.order.backend.service.request.PlaceOrderRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderRequestMapper implements IMapper<PlaceOrderRequest, Order> {
    @Override
    public Order mapFrom(PlaceOrderRequest placeOrderRequest) {
        List<OrderItem> orderItems = placeOrderRequest.getItemList()
                .stream()
                .map(orderItem -> OrderItem.builder()
                        .item(orderItem.getName())
                        .amount(orderItem.getAmount())
                        .price(orderItem.getPrice())
                        .build())
                .collect(Collectors.toList());
        return Order.builder()
                .createdAt(System.currentTimeMillis())
                .orderItems(orderItems)
                .build();
    }

    @Override
    public PlaceOrderRequest mapTo(Order order) {
        return null;
    }
}
