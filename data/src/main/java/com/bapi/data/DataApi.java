package com.bapi.data;

import com.bapi.data.repository.*;
import com.bapi.platform.PlatformApi;

public interface DataApi extends PlatformApi {
    IUserRepository userRepository();

    IUserDataRepository userDataRepository();

    ITokenRepository tokenRepository();

    IOrderRepository orderRepository();

    IOrderDataRepository orderDataRepository();
}
