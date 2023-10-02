package com.bapi.service.request.mapper;

import com.bapi.domain.IMapper;
import com.bapi.domain.Order;
import com.bapi.domain.OrderItem;
import com.bapi.service.request.PlaceOrderRequest;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderRequestMapper implements IMapper<PlaceOrderRequest, Order> {
    @Override
    public Order mapFrom(PlaceOrderRequest placeOrderRequest) {
        Order order = new Order();
        order.setCreatedAt(System.currentTimeMillis());
        order.setOrderItems(
                placeOrderRequest.getItemList()
                        .stream()
                        .map(orderItem -> new OrderItem(orderItem.getName(),
                                orderItem.getAmount(),
                                orderItem.getPrice()))
                        .collect(Collectors.toList())
        );
        return order;
    }

    @Override
    public PlaceOrderRequest mapTo(Order order) {
        return null;
    }
}
