package com.bapi.springbackend.repository;

import com.bapi.springbackend.domain.Token;

public interface ITokenRepository extends IRepository<Token, String> {
    Token findTokenByUserNameAndDeviceId(String deviceId, String userName);
}
