package com.bapi.auth;

import com.bapi.auth.authorization.AuthToken;
import com.bapi.auth.authorization.IAuthTokenManager;
import com.bapi.auth.creation.IAccountManager;
import com.bapi.auth.session.ISessionManager;
import com.bapi.domain.IMapper;
import com.bapi.domain.Token;
import com.bapi.platform.PlatformApi;
import org.springframework.security.authentication.AuthenticationManager;

public interface AuthApi extends PlatformApi {
    IAuthTokenManager authTokenManager();

    IAccountManager accountManager();

    AuthenticationManager authenticationManager();

    ISessionManager sessionManager();

    IMapper<AuthToken, Token> authTokenToTokenMapper();
}
