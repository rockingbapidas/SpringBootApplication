package com.bapi.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Order {
    private String orderId;
    private Long createdAt;
    private List<OrderItem> orderItems;
}
