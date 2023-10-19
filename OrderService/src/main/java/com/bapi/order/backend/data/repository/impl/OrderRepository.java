package com.bapi.order.backend.data.repository.impl;

import com.bapi.order.backend.data.entity.OrderEntity;
import com.bapi.order.backend.data.repository.IOrderRepository;
import com.bapi.order.backend.data.source.IOrderDataSource;
import com.bapi.order.backend.domain.IMapper;
import com.bapi.order.backend.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class OrderRepository implements IOrderRepository {
    private final String TAG = OrderRepository.class.getSimpleName();

    @Autowired
    private IOrderDataSource orderEntityDao;
    @Autowired
    private IMapper<Order, OrderEntity> orderEntityIMapper;

    @Override
    public List<Order> findAllByUserId(Long userId) {
        Logger.getLogger(TAG).info("findAllByUserId " + userId);
        return orderEntityDao.findByUserId(userId).map(orderEntities -> orderEntities
                        .stream()
                        .map(orderEntityIMapper::mapTo)
                        .collect(Collectors.toList()))
                .orElse(null);
    }

    @Override
    public Order saveByUserId(Long userId, Order order) {
        Logger.getLogger(TAG).info("saveByUserId " + " " + userId + " " + order);
        OrderEntity entity = orderEntityIMapper.mapFrom(order);
        entity.setUserId(userId);
        OrderEntity orderEntity = orderEntityDao.save(entity);
        return orderEntityIMapper.mapTo(orderEntity);
    }

    @Override
    public Order findById(String id) {
        Logger.getLogger(TAG).info("findById " + id);
        return orderEntityDao.findById(id).map(orderEntityIMapper::mapTo).orElse(null);
    }

    @Override
    public List<Order> findAll() {
        Logger.getLogger(TAG).info("findAll ");
        return orderEntityDao.findAll()
                .stream()
                .map(orderEntityIMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public Order save(Order orderEntity) {
        Logger.getLogger(TAG).info("save " + orderEntity);
        throw new RuntimeException("Please use save by user id");
    }

    @Override
    public Order update(Order orderEntity, String... params) {
        Logger.getLogger(TAG).info("update " + orderEntity + " " + Arrays.toString(params));
        return orderEntityIMapper.mapTo(orderEntityDao.save(orderEntityIMapper.mapFrom(orderEntity)));
    }

    @Override
    public boolean delete(Order orderEntity) {
        Logger.getLogger(TAG).info("delete " + orderEntity);
        orderEntityDao.delete(orderEntityIMapper.mapFrom(orderEntity));
        return true;
    }
}
