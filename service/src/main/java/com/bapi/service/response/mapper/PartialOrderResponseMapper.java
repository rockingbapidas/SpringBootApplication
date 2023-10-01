package com.bapi.service.response.mapper;

import com.bapi.domain.IMapper;
import com.bapi.domain.Order;
import com.bapi.service.response.PartialOrderResponse;
import org.springframework.stereotype.Component;

@Component
public class PartialOrderResponseMapper implements IMapper<Order, PartialOrderResponse> {

    @Override
    public PartialOrderResponse mapFrom(Order order) {
        return new PartialOrderResponse(order.getOrderId(), order.getCreatedAt());
    }

    @Override
    public Order mapTo(PartialOrderResponse partialOrderResponse) {
        return null;
    }
}
