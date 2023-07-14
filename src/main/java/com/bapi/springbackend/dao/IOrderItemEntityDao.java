package com.bapi.springbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IOrderItemEntityDao extends JpaRepository<OrderItemEntity, Long> {
    @Query("SELECT orderItems FROM OrderItemEntity orderItems WHERE orderItems.orderId = :orderId")
    Optional<List<OrderItemEntity>> findOrderItemsByOrderId(@Param("orderId") Long orderId);
}
