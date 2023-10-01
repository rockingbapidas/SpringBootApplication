package com.bapi.service.services;

import com.bapi.auth.AuthApi;
import com.bapi.data.DataApi;
import com.bapi.domain.IMapper;
import com.bapi.domain.Order;
import com.bapi.domain.OrderItem;
import com.bapi.platform.header.HeaderParams;
import com.bapi.service.exception.OrderDetailNotFound;
import com.bapi.service.request.PlaceOrderRequest;
import com.bapi.service.response.OrderResponse;
import com.bapi.service.response.OrdersResponse;
import com.bapi.service.response.PartialOrderResponse;
import com.bapi.service.response.SumOfOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final String TAG = OrderServiceImpl.class.getSimpleName();

    @Autowired
    private AuthApi authApi;

    @Autowired
    private DataApi dataApi;

    @Autowired
    private IMapper<Order, OrderResponse> orderOrderResponseIMapper;
    @Autowired
    private IMapper<Order, PartialOrderResponse> orderPartialOrderResponseIMapper;
    @Autowired
    private IMapper<PlaceOrderRequest, Order> placeOrderRequestOrderIMapper;

    @Override
    public OrderResponse placeOrders(HeaderParams headerParams, PlaceOrderRequest placeOrderRequest) {
        Order order = placeOrderRequestOrderIMapper.mapFrom(placeOrderRequest);
        Long userId = authApi.sessionManager().extractUserIdFromHeader(headerParams);
        Order savedOrder = dataApi.orderRepository().saveByUserId(userId, order);
        List<OrderItem> orderItems = dataApi.orderDataRepository().saveAll(order.getOrderId(), order.getOrderItems());
        savedOrder.setOrderItems(orderItems);
        return orderOrderResponseIMapper.mapFrom(savedOrder);
    }

    @Override
    public OrdersResponse getAllOrdersByUserId(HeaderParams headerParams) {
        Long userId = authApi.sessionManager().extractUserIdFromHeader(headerParams);
        List<Order> orderList = dataApi.orderRepository().findAllByUserId(userId);
        return new OrdersResponse(orderList.stream()
                .map(orderPartialOrderResponseIMapper::mapFrom)
                .collect(Collectors.toList()));
    }

    @Override
    public OrderResponse getOrderById(Long orderId) throws Throwable {
        Order order = dataApi.orderRepository().findById(orderId);
        if (order == null) throw new OrderDetailNotFound();
        List<OrderItem> orderItems = dataApi.orderDataRepository().findByOrderId(order.getOrderId());
        order.setOrderItems(orderItems);
        return orderOrderResponseIMapper.mapFrom(order);
    }

    @Override
    public SumOfOrderResponse getSumOfOrderById(Long orderId) throws Throwable {
        Order order = dataApi.orderRepository().findById(orderId);
        if (order == null) throw new OrderDetailNotFound();
        List<OrderItem> orderItems = dataApi.orderDataRepository().findByOrderId(order.getOrderId());
        order.setOrderItems(orderItems);
        return new SumOfOrderResponse(sumOfOrder(order));
    }

    private Double sumOfOrder(Order order) {
        double sum = 0;
        for (OrderItem orderItem : order.getOrderItems()) {
            sum += orderItem.getPrice() * orderItem.getAmount();
        }
        return sum;
    }
}
