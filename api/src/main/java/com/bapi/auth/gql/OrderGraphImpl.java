package com.bapi.auth.gql;

import com.bapi.auth.base.BaseOrder;
import com.bapi.auth.contract.OrderApi;
import com.bapi.platform.header.HeaderParams;
import com.bapi.service.base.BaseResponse;
import com.bapi.service.request.PlaceOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class OrderGraphImpl extends BaseOrder implements OrderApi {
    private final String TAG = OrderGraphImpl.class.getSimpleName();
    @Autowired
    private HttpServletRequest httpServletRequest;

    @QueryMapping("getAllOrders")
    @PreAuthorize("isAuthenticated()")
    @Override
    public BaseResponse<?> listOrders() {
        Logger.getLogger(TAG).info("List of orders ");
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return getAllOrders(headerParams);
    }

    @QueryMapping("getOrder")
    @PreAuthorize("isAuthenticated()")
    @Override
    public BaseResponse<?> getOrder(@Argument String orderId) {
        Logger.getLogger(TAG).info("Get order by id " + orderId);
        return getOrderById(orderId);
    }

    @QueryMapping("sumOfOrder")
    @PreAuthorize("isAuthenticated()")
    @Override
    public BaseResponse<?> calculateSumOfOrder(@Argument String orderId) {
        Logger.getLogger(TAG).info("Sum of order by id " + orderId);
        return calculateSumOrder(orderId);
    }

    @MutationMapping("placeOrder")
    @PreAuthorize("isAuthenticated()")
    @Override
    public BaseResponse<?> placeOrder(@Argument PlaceOrderRequest placeOrderRequest) {
        Logger.getLogger(TAG).info("Place orders from cart === " + placeOrderRequest);
        HeaderParams headerParams = HeaderParams.builder().setHeaders(httpServletRequest).build();
        return saveOrder(headerParams, placeOrderRequest);
    }
}
