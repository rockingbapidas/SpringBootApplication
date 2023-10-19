package com.bapi.auth.backend.data;

import com.bapi.auth.backend.data.repository.ITokenRepository;
import com.bapi.auth.backend.data.repository.IUserDataRepository;
import com.bapi.auth.backend.data.repository.IUserRepository;
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
}
