package com.bapi.springbackend.service;

import com.bapi.springbackend.auth.creation.UpdateAccount;
import com.bapi.springbackend.auth.header.HeaderParams;
import com.bapi.springbackend.auth.authorization.IAuthTokenManager;
import com.bapi.springbackend.auth.creation.Account;
import com.bapi.springbackend.auth.creation.CreateAccount;
import com.bapi.springbackend.auth.creation.IAccountManager;
import com.bapi.springbackend.auth.session.ISessionManager;
import com.bapi.springbackend.domain.Token;
import com.bapi.springbackend.domain.Person;
import com.bapi.springbackend.exceptions.SomeThingWentWrong;
import com.bapi.springbackend.exceptions.UserInfoNotFound;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.request.LoginRequest;
import com.bapi.springbackend.request.ProfileUpdateRequest;
import com.bapi.springbackend.request.SignupRequest;
import com.bapi.springbackend.response.AuthResponse;
import com.bapi.springbackend.response.ProfileUpdateResponse;
import com.bapi.springbackend.response.TokenResponse;
import com.bapi.springbackend.response.UserDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AuthService implements IAuthService {
    private final String TAG = AuthService.class.getSimpleName();
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAccountManager accountManager;
    @Autowired
    private IAuthTokenManager authTokenManager;
    @Autowired
    private ISessionManager sessionManager;

    @Autowired
    private IMapper<Token, TokenResponse> tokenResponseMapper;
    @Autowired
    private IMapper<SignupRequest, CreateAccount> createAccountMapper;
    @Autowired
    private IMapper<Person, UserDataResponse> userDataResponseMapper;
    @Autowired
    private IMapper<ProfileUpdateRequest, UpdateAccount> updateAccountMapper;

    @Override
    public AuthResponse login(LoginRequest loginRequest, HeaderParams headerParams) throws Throwable {
        Logger.getLogger(TAG).info("Login " + loginRequest);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()
                )
        );
        if (authentication.getDetails() != null) {
            Person person = (Person) authentication.getDetails();
            Token token = authTokenManager.createToken(person, headerParams.getDeviceType(),
                    headerParams.getDeviceId());
            return new AuthResponse(
                    userDataResponseMapper.mapFrom(person),
                    tokenResponseMapper.mapFrom(token)
            );
        }
        throw new UserInfoNotFound();
    }

    @Override
    public ProfileUpdateResponse update(ProfileUpdateRequest profileUpdateRequest, HeaderParams headerParams) throws Throwable {
        Logger.getLogger(TAG).info("Update " + profileUpdateRequest);
        boolean update = accountManager.updateAccount(updateAccountMapper.mapFrom(profileUpdateRequest),
                sessionManager.extractUserIdFromHeader(headerParams));
        if (update) {
            return new ProfileUpdateResponse(true);
        }
        throw new UserInfoNotFound();
    }

    @Override
    public AuthResponse signup(SignupRequest signupRequest, HeaderParams headerParams) throws Throwable {
        Logger.getLogger(TAG).info("Signup " + signupRequest);
        Account account = accountManager.createAccount(createAccountMapper.mapFrom(signupRequest));
        if (account.getAccountDetails() != null) {
            Person newPerson = (Person) account.getAccountDetails();
            Token token = authTokenManager.createToken(newPerson, headerParams.getDeviceType(),
                    headerParams.getDeviceId());
            return new AuthResponse(
                    userDataResponseMapper.mapFrom(newPerson),
                    tokenResponseMapper.mapFrom(token)
            );
        }
        throw new SomeThingWentWrong();
    }

    @Override
    public void logout(HeaderParams headerParams) throws Throwable {
        Logger.getLogger(TAG).info("logout ");


        throw new SomeThingWentWrong();
    }
}
