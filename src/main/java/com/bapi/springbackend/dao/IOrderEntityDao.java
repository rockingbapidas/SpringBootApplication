package com.bapi.springbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IOrderEntityDao extends JpaRepository<OrderEntity, Long> {
    @Query("SELECT order FROM OrderEntity order WHERE order.userId = :userId")
    Optional<List<OrderEntity>> findOrdersByUserId(@Param("userId") Long userId);
}
