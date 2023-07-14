package com.bapi.springbackend.controller.rest;

import com.bapi.springbackend.auth.header.HeaderParams;
import com.bapi.springbackend.controller.BaseOrderController;
import com.bapi.springbackend.request.PlaceOrderRequest;
import com.bapi.springbackend.response.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.Logger;

@RestController
public class OrderController extends BaseOrderController {
    private final String TAG = OrderController.class.getSimpleName();

    @GetMapping("/order")
    @ResponseBody
    public BaseResponse<?> listOrders(@RequestHeader Map<String, String> headers) {
        Logger.getLogger(TAG).info("List of orders ");
        HeaderParams headerParams = HeaderParams.builder().setHeaders(headers).build();
        return getAllOrders(headerParams);
    }

    @GetMapping("/order/{orderId}")
    @ResponseBody
    public BaseResponse<?> getOrder(@PathVariable String orderId) {
        Logger.getLogger(TAG).info("Get order by id " + orderId);
        return getOrderById(orderId);
    }

    @GetMapping("/order/{orderId}/total")
    @ResponseBody
    public BaseResponse<?> calculateSumOfOrder(@PathVariable String orderId) {
        Logger.getLogger(TAG).info("Sum of order by id " + orderId);
        return calculateSumOrder(orderId);
    }

    @PostMapping("/order/placeOrder")
    @ResponseBody
    public BaseResponse<?> placeOrder(@RequestHeader Map<String, String> headers, @RequestBody PlaceOrderRequest placeOrderRequest) {
        Logger.getLogger(TAG).info("Place orders from cart === " + headers + " " + placeOrderRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(headers).build();
        return saveOrder(headerParams, placeOrderRequest);
    }
}
