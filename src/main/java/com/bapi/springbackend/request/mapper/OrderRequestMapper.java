package com.bapi.springbackend.request.mapper;

import com.bapi.springbackend.domain.Order;
import com.bapi.springbackend.domain.OrderItem;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.request.OrderItemRequest;
import com.bapi.springbackend.request.PlaceOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderRequestMapper implements IMapper<PlaceOrderRequest, Order> {
    @Autowired
    private IMapper<OrderItemRequest, OrderItem> orderItemRequestOrderItemIMapper;

    @Override
    public Order mapFrom(PlaceOrderRequest placeOrderRequest) {
        Order order = new Order();
        order.setCreatedAt(System.currentTimeMillis());
        order.setOrderItems(
                placeOrderRequest.getItemList()
                        .stream()
                        .map(orderItemRequestOrderItemIMapper::mapFrom)
                        .collect(Collectors.toSet())
        );
        return order;
    }
}
