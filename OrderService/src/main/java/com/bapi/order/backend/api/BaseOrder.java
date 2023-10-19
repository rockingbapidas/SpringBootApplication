package com.bapi.order.backend.api;

import com.bapi.order.backend.service.ServiceApi;
import com.bapi.order.backend.service.base.BaseResponse;
import com.bapi.order.backend.service.base.ResponseStatus;
import com.bapi.order.backend.service.request.PlaceOrderRequest;
import com.bapi.order.backend.service.response.OrderResponse;
import com.bapi.order.backend.service.response.OrdersResponse;
import com.bapi.order.backend.service.response.SumOfOrderResponse;
import com.bapi.platform.header.HeaderParams;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseOrder {
    @Autowired
    private ServiceApi serviceApi;

    protected BaseResponse<?> getAllOrders(HeaderParams headerParams) {
        try {
            OrdersResponse orderResponses = serviceApi.orderService().getAllOrdersByUserId(headerParams);
            return new BaseResponse<>(ResponseStatus.success(), orderResponses);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> getOrderById(String orderId) {
        try {
            OrderResponse orderResponses = serviceApi.orderService().getOrderById(orderId);
            return new BaseResponse<>(ResponseStatus.success(), orderResponses);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> calculateSumOrder(String orderId) {
        try {
            SumOfOrderResponse response = serviceApi.orderService().getSumOfOrderById(orderId);
            return new BaseResponse<>(ResponseStatus.success(), response);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> saveOrder(HeaderParams headerParams, PlaceOrderRequest placeOrderRequest) {
        try {
            OrderResponse orderResponses = serviceApi.orderService().placeOrders(headerParams, placeOrderRequest);
            return new BaseResponse<>(ResponseStatus.success(), orderResponses);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }
}
