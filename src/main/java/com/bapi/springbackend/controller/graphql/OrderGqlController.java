package com.bapi.springbackend.controller.graphql;

import com.bapi.springbackend.auth.header.HeaderParams;
import com.bapi.springbackend.controller.BaseOrderController;
import com.bapi.springbackend.request.PlaceOrderRequest;
import com.bapi.springbackend.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class OrderGqlController extends BaseOrderController {
    private final String TAG = OrderGqlController.class.getSimpleName();
    @Autowired
    private HttpServletRequest httpServletRequest;

    @QueryMapping("getAllOrders")
    @PreAuthorize("isAuthenticated()")
    public BaseResponse<?> listOrders() {
        Logger.getLogger(TAG).info("List of orders ");
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return getAllOrders(headerParams);
    }

    @QueryMapping("getOrder")
    @PreAuthorize("isAuthenticated()")
    public BaseResponse<?> getOrder(@Argument String orderId) {
        Logger.getLogger(TAG).info("Get order by id " + orderId);
        return getOrderById(orderId);
    }

    @QueryMapping("sumOfOrder")
    @PreAuthorize("isAuthenticated()")
    public BaseResponse<?> calculateSumOfOrder(@Argument String orderId) {
        Logger.getLogger(TAG).info("Sum of order by id " + orderId);
        return calculateSumOrder(orderId);
    }

    @MutationMapping("placeOrder")
    @PreAuthorize("isAuthenticated()")
    public BaseResponse<?> placeOrder(@Argument PlaceOrderRequest placeOrderRequest) {
        Logger.getLogger(TAG).info("Place orders from cart === " + placeOrderRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return saveOrder(headerParams, placeOrderRequest);
    }
}
