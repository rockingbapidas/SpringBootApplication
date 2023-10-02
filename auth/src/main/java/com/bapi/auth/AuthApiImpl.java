package com.bapi.auth;

import com.bapi.auth.authorization.AuthToken;
import com.bapi.auth.authorization.IAuthTokenManager;
import com.bapi.auth.creation.IAccountManager;
import com.bapi.auth.session.ISessionManager;
import com.bapi.domain.IMapper;
import com.bapi.domain.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

@Component
public class AuthApiImpl implements AuthApi {
    @Autowired
    private IAuthTokenManager authTokenManager;
    @Autowired
    private IAccountManager accountManager;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ISessionManager sessionManager;
    @Autowired
    private IMapper<AuthToken, Token> authTokenToTokenMapper;

    @Override
    public IAuthTokenManager authTokenManager() {
        return authTokenManager;
    }

    @Override
    public IAccountManager accountManager() {
        return accountManager;
    }

    @Override
    public AuthenticationManager authenticationManager() {
        return authenticationManager;
    }

    @Override
    public ISessionManager sessionManager() {
        return sessionManager;
    }

    @Override
    public IMapper<AuthToken, Token> authTokenToTokenMapper() {
        return authTokenToTokenMapper;
    }
}
