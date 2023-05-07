package com.bapi.springbackend.service;

import com.bapi.springbackend.auth.header.HeaderParams;
import com.bapi.springbackend.request.PlaceOrderRequest;
import com.bapi.springbackend.response.OrderResponse;

import java.util.List;

public interface IOrderService {
    OrderResponse placeOrders(HeaderParams headerParams, PlaceOrderRequest placeOrderRequest);
    List<OrderResponse> getAllOrdersByUserId(HeaderParams headerParams);
    OrderResponse getOrderById(Long orderId) throws Throwable;
    Double getSumOfOrderById(Long orderId) throws Throwable;
}
