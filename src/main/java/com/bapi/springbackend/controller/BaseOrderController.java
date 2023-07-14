package com.bapi.springbackend.controller;

import com.bapi.springbackend.auth.header.HeaderParams;
import com.bapi.springbackend.request.PlaceOrderRequest;
import com.bapi.springbackend.response.*;
import com.bapi.springbackend.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseOrderController {
    @Autowired
    private IOrderService orderService;

    protected BaseResponse<?> getAllOrders(HeaderParams headerParams) {
        try {
            List<PartialOrderResponse> orderResponses = orderService.getAllOrdersByUserId(headerParams);
            return new BaseResponse<>(ResponseStatus.success(), new OrdersResponse(orderResponses));
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> getOrderById(String orderId) {
        try {
            OrderResponse orderResponses = orderService.getOrderById(Long.valueOf(orderId));
            return new BaseResponse<>(ResponseStatus.success(), orderResponses);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> calculateSumOrder(String orderId) {
        try {
            double sum = orderService.getSumOfOrderById(Long.valueOf(orderId));
            return new BaseResponse<>(ResponseStatus.success(), new SumOfOrderResponse(sum));
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> saveOrder(HeaderParams headerParams, PlaceOrderRequest placeOrderRequest) {
        try {
            OrderResponse orderResponses = orderService.placeOrders(headerParams, placeOrderRequest);
            return new BaseResponse<>(ResponseStatus.success(), orderResponses);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }
}
