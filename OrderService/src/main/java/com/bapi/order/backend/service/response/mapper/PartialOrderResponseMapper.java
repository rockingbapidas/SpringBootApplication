package com.bapi.order.backend.service.response.mapper;

import com.bapi.order.backend.domain.IMapper;
import com.bapi.order.backend.domain.Order;
import com.bapi.order.backend.service.response.PartialOrderResponse;
import org.springframework.stereotype.Component;

@Component
public class PartialOrderResponseMapper implements IMapper<Order, PartialOrderResponse> {

    @Override
    public PartialOrderResponse mapFrom(Order order) {
        return PartialOrderResponse.builder()
                .orderId(order.getOrderId())
                .createdAt(order.getCreatedAt())
                .build();
    }

    @Override
    public Order mapTo(PartialOrderResponse partialOrderResponse) {
        return null;
    }
}
