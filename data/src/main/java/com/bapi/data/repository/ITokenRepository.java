package com.bapi.data.repository;

import com.bapi.data.repository.base.IRepository;
import com.bapi.domain.Token;

public interface ITokenRepository extends IRepository<Token, Long> {
    Token findTokenByUserNameAndDeviceId(String deviceId, String userName);
}
