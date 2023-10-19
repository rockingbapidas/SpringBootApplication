package com.bapi.auth.backend;

import com.bapi.auth.backend.authorization.AuthToken;
import com.bapi.auth.backend.authorization.IAuthTokenManager;
import com.bapi.auth.backend.creation.IAccountManager;
import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.Token;
import com.bapi.auth.backend.session.ISessionManager;
import com.bapi.platform.PlatformApi;
import org.springframework.security.authentication.AuthenticationManager;

public interface AuthApi extends PlatformApi {
    IAuthTokenManager authTokenManager();

    IAccountManager accountManager();

    AuthenticationManager authenticationManager();

    ISessionManager sessionManager();

    IMapper<AuthToken, Token> authTokenToTokenMapper();
}
