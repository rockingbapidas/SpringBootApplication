package com.bapi.service.request.mapper;

import com.bapi.domain.IMapper;
import com.bapi.domain.Order;
import com.bapi.domain.OrderItem;
import com.bapi.service.request.PlaceOrderRequest;
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
