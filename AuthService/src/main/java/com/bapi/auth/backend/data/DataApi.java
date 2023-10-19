package com.bapi.auth.backend.data;

import com.bapi.auth.backend.data.repository.ITokenRepository;
import com.bapi.auth.backend.data.repository.IUserDataRepository;
import com.bapi.auth.backend.data.repository.IUserRepository;
import com.bapi.platform.PlatformApi;

public interface DataApi extends PlatformApi {
    IUserRepository userRepository();

    IUserDataRepository userDataRepository();

    ITokenRepository tokenRepository();
}
