package com.bapi.service.response;

public class PartialOrderResponse {
    private Long orderId;
    private Long createdAt;

    public PartialOrderResponse(Long orderId, Long createdAt) {
        this.orderId = orderId;
        this.createdAt = createdAt;
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
}
