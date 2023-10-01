package com.bapi.service.response;

import java.util.List;

public class OrderResponse {
    private Long orderId;
    private Long createdAt;
    private List<OrderItemResponse> contents;

    public OrderResponse(Long orderId, Long createdAt, List<OrderItemResponse> contents) {
        this.orderId = orderId;
        this.createdAt = createdAt;
        this.contents = contents;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderItemResponse> getContents() {
        return contents;
    }

    public void setContents(List<OrderItemResponse> contents) {
        this.contents = contents;
    }
}
