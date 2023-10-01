package com.bapi.data.entity;
import javax.persistence.*;
@Entity
@Table(name = "order_data")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long orderId;
    private Long userId;
    private Long createdAt;
    @Version
    private int version;
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
