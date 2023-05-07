package com.bapi.springbackend.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlaceOrderRequest {
    @SerializedName("itemList")
    private List<OrderItemRequest> mOrderItemRequest;

    public List<OrderItemRequest> getItemList() {
        return mOrderItemRequest;
    }

    public void setItemList(List<OrderItemRequest> orderItemRequest) {
        mOrderItemRequest = orderItemRequest;
    }
}
