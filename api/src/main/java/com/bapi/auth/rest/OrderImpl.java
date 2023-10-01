package com.bapi.auth.rest;

import com.bapi.auth.base.BaseOrder;
import com.bapi.auth.contract.OrderApi;
import com.bapi.platform.header.HeaderParams;
import com.bapi.service.base.BaseResponse;
import com.bapi.service.request.PlaceOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class OrderImpl extends BaseOrder implements OrderApi {
    private final String TAG = OrderImpl.class.getSimpleName();
    @Autowired
    private HttpServletRequest httpServletRequest;

    @GetMapping("/order")
    @ResponseBody
    @Override
    public BaseResponse<?> listOrders() {
        Logger.getLogger(TAG).info("List of orders ");
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return getAllOrders(headerParams);
    }

    @GetMapping("/order/{orderId}")
    @ResponseBody
    @Override
    public BaseResponse<?> getOrder(@PathVariable String orderId) {
        Logger.getLogger(TAG).info("Get order by id " + orderId);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return getOrderById(orderId);
    }

    @GetMapping("/order/{orderId}/total")
    @ResponseBody
    @Override
    public BaseResponse<?> calculateSumOfOrder(@PathVariable String orderId) {
        Logger.getLogger(TAG).info("Sum of order by id " + orderId);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return calculateSumOrder(orderId);
    }

    @PostMapping("/order/placeOrder")
    @ResponseBody
    @Override
    public BaseResponse<?> placeOrder(@RequestBody PlaceOrderRequest placeOrderRequest) {
        Logger.getLogger(TAG).info("Place orders from cart ===  " + placeOrderRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return saveOrder(headerParams, placeOrderRequest);
    }
}
