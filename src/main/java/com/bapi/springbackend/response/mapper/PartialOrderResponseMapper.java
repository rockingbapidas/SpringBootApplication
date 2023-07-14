package com.bapi.springbackend.response.mapper;

import com.bapi.springbackend.domain.Order;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.response.PartialOrderResponse;
import org.springframework.stereotype.Component;

@Component
public class PartialOrderResponseMapper implements IMapper<Order, PartialOrderResponse> {

    @Override
    public PartialOrderResponse mapFrom(Order order) {
        return new PartialOrderResponse(order.getOrderId(), order.getCreatedAt());
    }
}
