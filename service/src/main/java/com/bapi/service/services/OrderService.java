package com.bapi.service.services;

import com.bapi.platform.header.HeaderParams;
import com.bapi.service.request.PlaceOrderRequest;
import com.bapi.service.response.OrderResponse;
import com.bapi.service.response.OrdersResponse;
import com.bapi.service.response.SumOfOrderResponse;

public interface OrderService {
    OrderResponse placeOrders(HeaderParams headerParams, PlaceOrderRequest placeOrderRequest) throws Throwable;

    OrdersResponse getAllOrdersByUserId(HeaderParams headerParams) throws Throwable;

    OrderResponse getOrderById(Long orderId) throws Throwable;

    SumOfOrderResponse getSumOfOrderById(Long orderId) throws Throwable;
}
