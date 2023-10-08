package com.bapi.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orderDetails")
public class OrderItemEntity {
    @Id
    private String id;
    @Version
    private int version;
    private String orderId;
    private String item;
    private double amount;
    private double price;
}
