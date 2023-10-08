package com.bapi.data.repository.impl;

import com.bapi.data.entity.OrderItemEntity;
import com.bapi.data.repository.IOrderDataRepository;
import com.bapi.data.source.IOrderItemDataSource;
import com.bapi.domain.IMapper;
import com.bapi.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class OrderDataRepository implements IOrderDataRepository {
    private final String TAG = OrderDataRepository.class.getSimpleName();

    @Autowired
    private IOrderItemDataSource orderItemEntityDao;

    @Autowired
    private IMapper<OrderItem, OrderItemEntity> orderItemEntityIMapper;

    @Override
    public List<OrderItem> findByOrderId(String orderId) {
        Logger.getLogger(TAG).info("findByOrderId " + orderId);
        return orderItemEntityDao.findByOrderId(orderId)
                .map(orderItemEntities -> orderItemEntities.stream()
                        .map(orderItemEntityIMapper::mapTo)
                        .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public List<OrderItem> saveAll(String orderId, List<OrderItem> orderItems) {
        Set<OrderItemEntity> orderItemEntities = orderItems
                .stream()
                .map(orderItemEntityIMapper::mapFrom)
                .peek(orderItemEntity -> orderItemEntity.setOrderId(orderId))
                .collect(Collectors.toSet());
        return orderItemEntityDao.saveAll(orderItemEntities)
                .stream()
                .map(orderItemEntityIMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItem saveByOrderId(String orderId, OrderItem orderItems) {
        return null;
    }

    @Override
    public OrderItem findById(String id) {
        Logger.getLogger(TAG).info("findById " + id);
        return orderItemEntityDao.findById(id).map(orderItemEntityIMapper::mapTo).orElse(null);
    }

    @Override
    public List<OrderItem> findAll() {
        Logger.getLogger(TAG).info("findAll ");
        return orderItemEntityDao.findAll()
                .stream()
                .map(orderItemEntityIMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItem save(OrderItem orderItemEntity) {
        Logger.getLogger(TAG).info("save " + orderItemEntity);
        throw new RuntimeException("Please use save by order id");
    }

    @Override
    public OrderItem update(OrderItem orderItemEntity, String... params) {
        Logger.getLogger(TAG).info("update " + orderItemEntity + " " + Arrays.toString(params));
        return orderItemEntityIMapper.mapTo(orderItemEntityDao.save(orderItemEntityIMapper.mapFrom(orderItemEntity)));
    }

    @Override
    public boolean delete(OrderItem orderItemEntity) {
        Logger.getLogger(TAG).info("delete " + orderItemEntity);
        orderItemEntityDao.delete(orderItemEntityIMapper.mapFrom(orderItemEntity));
        return true;
    }
}
