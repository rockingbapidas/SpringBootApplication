package com.bapi.service.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemResponse {
    private String item;
    private double amount;
    private double price;
}
