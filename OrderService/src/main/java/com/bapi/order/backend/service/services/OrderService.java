package com.bapi.order.backend.service.services;

import com.bapi.order.backend.service.request.PlaceOrderRequest;
import com.bapi.order.backend.service.response.OrderResponse;
import com.bapi.order.backend.service.response.OrdersResponse;
import com.bapi.order.backend.service.response.SumOfOrderResponse;
import com.bapi.platform.header.HeaderParams;

public interface OrderService {
    OrderResponse placeOrders(HeaderParams headerParams, PlaceOrderRequest placeOrderRequest) throws Throwable;

    OrdersResponse getAllOrdersByUserId(HeaderParams headerParams) throws Throwable;

    OrderResponse getOrderById(String orderId) throws Throwable;

    SumOfOrderResponse getSumOfOrderById(String orderId) throws Throwable;
}
