package com.bapi.order.backend.api;


import com.bapi.order.backend.service.base.BaseResponse;
import com.bapi.order.backend.service.request.PlaceOrderRequest;

/**
 * Order data api
 */
public interface OrderApi {
    /**
     * @return BaseResponse<OrdersResponse>
     */
    BaseResponse<?> listOrders();

    /**
     * @param orderId is for particular order relevant information
     * @return BaseResponse<OrderResponse>
     */
    BaseResponse<?> getOrder(String orderId);

    /**
     * @param orderId is for particular order relevant information
     * @return BaseResponse<SumOfOrderResponse>
     */
    BaseResponse<?> calculateSumOfOrder(String orderId);

    /**
     * @param placeOrderRequest is contained order related information
     * @return BaseResponse<PlaceOrderResponse>
     */
    BaseResponse<?> placeOrder(PlaceOrderRequest placeOrderRequest);
}
