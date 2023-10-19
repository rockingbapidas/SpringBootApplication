package com.bapi.order.backend.data;

import com.bapi.order.backend.data.repository.IOrderDataRepository;
import com.bapi.order.backend.data.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataApImpl implements DataApi {
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private IOrderDataRepository orderDataRepository;

    @Override
    public IOrderRepository orderRepository() {
        return orderRepository;
    }

    @Override
    public IOrderDataRepository orderDataRepository() {
        return orderDataRepository;
    }
}
