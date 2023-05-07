package com.bapi.springbackend.controller;

import com.bapi.springbackend.auth.header.HeaderParams;
import com.bapi.springbackend.auth.session.ISessionManager;
import com.bapi.springbackend.request.PlaceOrderRequest;
import com.bapi.springbackend.response.BaseResponse;
import com.bapi.springbackend.response.OrderResponse;
import com.bapi.springbackend.response.ResponseStatus;
import com.bapi.springbackend.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class OrderController {
    private final String TAG = OrderController.class.getSimpleName();
    @Autowired
    private IOrderService orderService;

    @GetMapping("/order")
    @ResponseBody
    public BaseResponse<?> listOrders(@RequestHeader Map<String, String> headers) {
        Logger.getLogger(TAG).info("List of orders ");
        try {
            HeaderParams headerParams = HeaderParams.builder().setHeaders(headers).build();
            List<OrderResponse> orderResponses = orderService.getAllOrdersByUserId(headerParams);
            return new BaseResponse<>(ResponseStatus.success(), orderResponses);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    @PostMapping("/order/placeOrder")
    @ResponseBody
    public BaseResponse<?> placeOrder(@RequestHeader Map<String, String> headers, @RequestBody PlaceOrderRequest placeOrderRequest) {
        Logger.getLogger(TAG).info("Place orders from cart === " + headers + " " + placeOrderRequest);
        try {
            HeaderParams headerParams = HeaderParams.builder().setHeaders(headers).build();
            OrderResponse orderResponses = orderService.placeOrders(headerParams, placeOrderRequest);
            return new BaseResponse<>(ResponseStatus.success(), orderResponses);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    @GetMapping("/order/{orderId}")
    @ResponseBody
    public BaseResponse<?> getOrder(@RequestHeader Map<String, String> headers, @PathVariable String orderId) {
        Logger.getLogger(TAG).info("Get order by id " + orderId);
        try {
            OrderResponse orderResponses = orderService.getOrderById(Long.valueOf(orderId));
            return new BaseResponse<>(ResponseStatus.success(), orderResponses);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }

    @GetMapping("/order/{orderId}/total")
    @ResponseBody
    public BaseResponse<?> calculateSumOfOrder(@RequestHeader Map<String, String> headers, @PathVariable String orderId) {
        Logger.getLogger(TAG).info("Sum of order by id " + orderId);
        try {
            double sum = orderService.getSumOfOrderById(Long.valueOf(orderId));
            return new BaseResponse<>(ResponseStatus.success(), sum);
        } catch (Throwable throwable) {
            return new BaseResponse<>(ResponseStatus.error(throwable.getMessage()), null);
        }
    }
}
