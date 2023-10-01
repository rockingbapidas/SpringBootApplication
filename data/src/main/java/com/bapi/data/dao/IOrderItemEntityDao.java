package com.bapi.data.dao;

import com.bapi.data.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrderItemEntityDao extends JpaRepository<OrderItemEntity, Long> {
    @Query("SELECT orderItems FROM OrderItemEntity orderItems WHERE orderItems.orderId = :orderId")
    Optional<List<OrderItemEntity>> findOrderItemsByOrderId(@Param("orderId") Long orderId);
}
