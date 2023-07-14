package com.bapi.springbackend.repository;

import com.bapi.springbackend.dao.IOrderEntityDao;
import com.bapi.springbackend.dao.IOrderItemEntityDao;
import com.bapi.springbackend.dao.OrderEntity;
import com.bapi.springbackend.dao.OrderItemEntity;
import com.bapi.springbackend.domain.Order;
import com.bapi.springbackend.domain.OrderItem;
import com.bapi.springbackend.mapper.IMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class OrderRepository implements IOrderRepository {
    private final String TAG = OrderRepository.class.getSimpleName();
    @Autowired
    private IOrderEntityDao orderEntityDao;
    @Autowired
    private IOrderItemEntityDao orderItemEntityDao;

    @Autowired
    private IMapper<Order, OrderEntity> orderEntityIMapper;
    @Autowired
    private IMapper<OrderEntity, Order> orderIMapper;

    @Autowired
    private IMapper<OrderItem, OrderItemEntity> orderItemEntityIMapper;
    @Autowired
    private IMapper<OrderItemEntity, OrderItem> orderItemIMapper;

    @Override
    public Order findById(Long id) {
        Logger.getLogger(TAG).info("findById " + id);
        Order order = orderEntityDao.findById(id).map(orderIMapper::mapFrom).orElseThrow();
        Set<OrderItem> orderItems = orderItemEntityDao.findOrderItemsByOrderId(id)
                .map(orderItemEntities -> orderItemEntities.stream().map(orderItemIMapper::mapFrom))
                .orElseThrow()
                .collect(Collectors.toSet());
        order.setOrderItems(orderItems);
        return order;
    }

    @Override
    public List<Order> findAll() {
        Logger.getLogger(TAG).info("findAll ");
        return new ArrayList<>(orderEntityDao.findAll())
                .stream()
                .map(orderIMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public Order save(Order order) {
        Logger.getLogger(TAG).info("save " + order);
        OrderEntity entity = orderEntityIMapper.mapFrom(order);
        return storeOrder(order, entity);
    }

    @Override
    public Order update(Order order, String... params) {
        Logger.getLogger(TAG).info("update " + order + " " + Arrays.toString(params));
        // Todo
        return order;
    }

    @Override
    public void delete(Order order) {
        Logger.getLogger(TAG).info("delete " + order);
        // Todo
    }

    @Override
    public Order saveByUserId(Long userId, Order order) {
        Logger.getLogger(TAG).info("saveByUserId " + " " + userId + " " + order);
        OrderEntity entity = orderEntityIMapper.mapFrom(order);
        entity.setUserId(userId);
        return storeOrder(order, entity);
    }

    @Override
    public List<Order> findAllByUserId(Long userId) {
        Logger.getLogger(TAG).info("findAllByUserId " + userId);
        List<OrderEntity> orderEntities = orderEntityDao.findOrdersByUserId(userId).orElseThrow();
        return orderEntities
                .stream()
                .map(orderIMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @NotNull
    private Order storeOrder(Order order, OrderEntity entity) {
        OrderEntity orderEntity = orderEntityDao.save(entity);
        Set<OrderItemEntity> orderItemEntities = order.getOrderItems()
                .stream()
                .map(orderItemEntityIMapper::mapFrom)
                .peek(orderItemEntity -> orderItemEntity.setOrderId(orderEntity.getOrderId()))
                .collect(Collectors.toSet());
        Set<OrderItemEntity> newOrderItemEntities = new HashSet<>(orderItemEntityDao.saveAll(orderItemEntities));
        Order savedOrder = orderIMapper.mapFrom(orderEntity);
        savedOrder.setOrderItems(newOrderItemEntities
                .stream()
                .map(orderItemIMapper::mapFrom)
                .collect(Collectors.toSet()));
        return savedOrder;
    }
}
