package com.bapi.springbackend.service;

import com.bapi.springbackend.auth.header.HeaderParams;
import com.bapi.springbackend.auth.session.ISessionManager;
import com.bapi.springbackend.domain.Order;
import com.bapi.springbackend.domain.Person;
import com.bapi.springbackend.exceptions.OrderDetailNotFound;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.managers.IOrderDataMapper;
import com.bapi.springbackend.repository.IOrderRepository;
import com.bapi.springbackend.repository.IPersonRepository;
import com.bapi.springbackend.request.PlaceOrderRequest;
import com.bapi.springbackend.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private IPersonRepository personRepository;

    @Autowired
    private ISessionManager sessionManager;

    @Autowired
    private IOrderDataMapper iOrderDataMapper;
    @Autowired
    private IMapper<Order, OrderResponse> orderOrderResponseIMapper;
    @Autowired
    private IMapper<PlaceOrderRequest, Order> placeOrderRequestOrderIMapper;

    @Override
    public OrderResponse placeOrders(HeaderParams headerParams, PlaceOrderRequest placeOrderRequest) {
        Order order = placeOrderRequestOrderIMapper.mapFrom(placeOrderRequest);
        Long userId = sessionManager.extractUserIdFromHeader(headerParams);
        return orderOrderResponseIMapper.mapFrom(orderRepository.saveByUserId(userId, order));
    }

    @Override
    public List<OrderResponse> getAllOrdersByUserId(HeaderParams headerParams) {
        Long userId = sessionManager.extractUserIdFromHeader(headerParams);
        List<Order> orderList = orderRepository.findAllByUserId(userId);
        return orderList.stream()
                .map(orderOrderResponseIMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getOrderById(Long orderId) throws Throwable {
        Order order = orderRepository.findById(orderId);
        if (order == null) throw new OrderDetailNotFound();
        return orderOrderResponseIMapper.mapFrom(order);
    }

    @Override
    public Double getSumOfOrderById(Long orderId) throws Throwable {
        Order order = orderRepository.findById(orderId);
        if (order == null) throw new OrderDetailNotFound();
        return iOrderDataMapper.sumOfOrder(order);
    }
}
