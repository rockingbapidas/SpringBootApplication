package com.bapi.springbackend.auth.authorization;

import com.bapi.springbackend.domain.Person;
import com.bapi.springbackend.domain.Token;
import org.springframework.transaction.annotation.Transactional;

public interface IAuthTokenManager {
    Token createToken(Person person, String deviceType, String deviceId);

    void destroyToken(Person person, String deviceId);
}
