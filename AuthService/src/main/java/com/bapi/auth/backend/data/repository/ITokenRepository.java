package com.bapi.auth.backend.data.repository;

import com.bapi.auth.backend.data.repository.base.IRepository;
import com.bapi.auth.backend.domain.Token;

public interface ITokenRepository extends IRepository<Token, Long> {
    Token findTokenByUserNameAndDeviceId(String deviceId, String userName);
}
