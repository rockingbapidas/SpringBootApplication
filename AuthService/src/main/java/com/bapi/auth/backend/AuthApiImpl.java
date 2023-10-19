package com.bapi.auth.backend;

import com.bapi.auth.backend.authorization.AuthToken;
import com.bapi.auth.backend.authorization.IAuthTokenManager;
import com.bapi.auth.backend.creation.IAccountManager;
import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.Token;
import com.bapi.auth.backend.session.ISessionManager;
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
