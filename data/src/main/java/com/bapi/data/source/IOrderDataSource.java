package com.bapi.data.source;

import com.bapi.data.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrderDataSource extends MongoRepository<OrderEntity, String> {
    Optional<List<OrderEntity>> findByUserId(Long userId);
}
