package com.bapi.service.request;

import java.util.List;

public class PlaceOrderRequest {
    private List<OrderItemRequest> mOrderItemRequest;

    public List<OrderItemRequest> getItemList() {
        return mOrderItemRequest;
    }

    public void setItemList(List<OrderItemRequest> orderItemRequest) {
        mOrderItemRequest = orderItemRequest;
    }
}
