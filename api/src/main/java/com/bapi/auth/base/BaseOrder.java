package com.bapi.auth.base;

import com.bapi.platform.header.HeaderParams;
import com.bapi.service.ServiceApi;
import com.bapi.service.base.BaseResponse;
import com.bapi.service.base.ResponseStatus;
import com.bapi.service.request.PlaceOrderRequest;
import com.bapi.service.response.OrderResponse;
import com.bapi.service.response.OrdersResponse;
import com.bapi.service.response.SumOfOrderResponse;
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
            OrderResponse orderResponses = serviceApi.orderService().getOrderById(Long.valueOf(orderId));
            return new BaseResponse<>(ResponseStatus.success(), orderResponses);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    protected BaseResponse<?> calculateSumOrder(String orderId) {
        try {
            SumOfOrderResponse response = serviceApi.orderService().getSumOfOrderById(Long.valueOf(orderId));
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
