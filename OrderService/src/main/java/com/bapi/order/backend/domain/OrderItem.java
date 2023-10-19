package com.bapi.order.backend.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItem {
    private String id;
    private String item;
    private double amount;
    private double price;
}
