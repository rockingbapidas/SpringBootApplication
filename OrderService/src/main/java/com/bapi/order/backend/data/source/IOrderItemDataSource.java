package com.bapi.order.backend.data.source;

import com.bapi.order.backend.data.entity.OrderItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrderItemDataSource extends MongoRepository<OrderItemEntity, String> {
    Optional<List<OrderItemEntity>> findByOrderId(String orderId);
}
