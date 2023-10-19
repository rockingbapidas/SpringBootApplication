package com.bapi.order.backend.service.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderResponse {
    private String orderId;
    private Long createdAt;
    private List<OrderItemResponse> contents;
}
