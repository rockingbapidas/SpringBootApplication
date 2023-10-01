package com.bapi.data;

import com.bapi.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataApImpl implements DataApi {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IUserDataRepository userDataRepository;
    @Autowired
    private ITokenRepository tokenRepository;
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private IOrderDataRepository orderDataRepository;

    @Override
    public IUserRepository userRepository() {
        return userRepository;
    }

    @Override
    public IUserDataRepository userDataRepository() {
        return userDataRepository;
    }

    @Override
    public ITokenRepository tokenRepository() {
        return tokenRepository;
    }

    @Override
    public IOrderRepository orderRepository() {
        return orderRepository;
    }

    @Override
    public IOrderDataRepository orderDataRepository() {
        return orderDataRepository;
    }
}
