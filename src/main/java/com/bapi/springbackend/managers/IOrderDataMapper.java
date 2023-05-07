package com.bapi.springbackend.managers;

import com.bapi.springbackend.domain.Order;
import com.bapi.springbackend.response.OrderResponse;

import java.util.List;
import java.util.Set;

public interface IOrderDataMapper {
    List<OrderResponse> mapToOrderResponse(Set<Order> orders);
    Double sumOfOrder(Order order);
}
