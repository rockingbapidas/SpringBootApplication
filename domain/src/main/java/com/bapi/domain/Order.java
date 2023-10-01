package com.bapi.domain;

import java.util.List;

public class Order {
    private Long orderId;
    private Long createdAt;

    private List<OrderItem> orderItems;

    public Order(Long orderId, Long createdAt) {
        this.orderId = orderId;
        this.createdAt = createdAt;
    }

    public Order() {

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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
