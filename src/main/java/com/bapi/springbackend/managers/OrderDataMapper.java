package com.bapi.springbackend.managers;

import com.bapi.springbackend.domain.Order;
import com.bapi.springbackend.domain.OrderItem;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper implements IOrderDataMapper {
    @Autowired
    private IMapper<Order, OrderResponse> orderResponseMapper;
    @Override
    public List<OrderResponse> mapToOrderResponse(Set<Order> orders) {
        return orders.stream().map(orderResponseMapper::mapFrom).collect(Collectors.toList());
    }

    @Override
    public Double sumOfOrder(Order order) {
        double sum = 0;
        for (OrderItem orderItem : order.getOrderItems()) {
            sum += orderItem.getPrice() * orderItem.getAmount();
        }
        return sum;
    }
}
