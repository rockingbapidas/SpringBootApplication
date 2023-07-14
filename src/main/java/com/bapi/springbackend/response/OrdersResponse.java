package com.bapi.springbackend.response;

import java.util.List;

public class OrdersResponse {
    private List<PartialOrderResponse> orders;

    public OrdersResponse(List<PartialOrderResponse> orders) {
        this.orders = orders;
    }

    public List<PartialOrderResponse> getOrders() {
        return orders;
    }

    public void setOrders(List<PartialOrderResponse> orders) {
        this.orders = orders;
    }
}
