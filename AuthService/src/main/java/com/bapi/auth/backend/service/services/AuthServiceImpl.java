package com.bapi.auth.backend.service.services;

import com.bapi.auth.backend.AuthApi;
import com.bapi.auth.backend.authorization.AuthToken;
import com.bapi.auth.backend.creation.Account;
import com.bapi.auth.backend.creation.CreateAccount;
import com.bapi.auth.backend.creation.UpdateAccount;
import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.Person;
import com.bapi.auth.backend.domain.PersonDetails;
import com.bapi.auth.backend.domain.Token;
import com.bapi.auth.backend.service.exception.SomeThingWentWrong;
import com.bapi.auth.backend.service.exception.UserInfoNotFound;
import com.bapi.auth.backend.service.request.LoginRequest;
import com.bapi.auth.backend.service.request.ProfileUpdateRequest;
import com.bapi.auth.backend.service.request.SignupRequest;
import com.bapi.auth.backend.service.response.AuthResponse;
import com.bapi.auth.backend.service.response.ProfileUpdateResponse;
import com.bapi.auth.backend.service.response.TokenResponse;
import com.bapi.auth.backend.service.response.UserDataResponse;
import com.bapi.platform.header.HeaderParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AuthServiceImpl implements AuthService {
    private final String TAG = AuthServiceImpl.class.getSimpleName();

    @Autowired
    private AuthApi authApi;
    @Autowired
    private IMapper<SignupRequest, CreateAccount> createAccountMapper;
    @Autowired
    private IMapper<ProfileUpdateRequest, UpdateAccount> updateAccountMapper;
    @Autowired
    private IMapper<Person, UserDataResponse> userDataResponseMapper;
    @Autowired
    private IMapper<Token, TokenResponse> tokenResponseMapper;

    @Override
    public AuthResponse signup(SignupRequest signupRequest, HeaderParams headerParams) throws Throwable {
        Logger.getLogger(TAG).info("signup " + signupRequest);
        CreateAccount createAccount = createAccountMapper.mapFrom(signupRequest);
        Account account = authApi.accountManager().createAccount(createAccount);
        if (account.getAccount() != null && account.getAccountDetails() != null) {
            // Cast to domain model
            Person newPerson = (Person) account.getAccount();
            PersonDetails newPersonDetails = (PersonDetails) account.getAccountDetails();
            newPerson.setPersonDetails(newPersonDetails);

            AuthToken authToken = authApi.authTokenManager().createToken(newPerson.getUserName(), headerParams.getDeviceType(),
                    headerParams.getDeviceId());
            Token token = authApi.authTokenToTokenMapper().mapFrom(authToken);

            return AuthResponse.builder()
                    .tokenResponse(tokenResponseMapper.mapFrom(token))
                    .userDataResponse(userDataResponseMapper.mapFrom(newPerson))
                    .build();
        }
        throw new SomeThingWentWrong();
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest, HeaderParams headerParams) throws Throwable {
        Logger.getLogger(TAG).info("Login " + loginRequest);
        Authentication authentication = authApi.authenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()
                )
        );
        if (authentication.getDetails() != null) {
            Person person = (Person) authentication.getDetails();
            AuthToken authToken = authApi.authTokenManager().createToken(person.getUserName(), headerParams.getDeviceType(),
                    headerParams.getDeviceId());
            Token token = authApi.authTokenToTokenMapper().mapFrom(authToken);
            return AuthResponse.builder()
                    .tokenResponse(tokenResponseMapper.mapFrom(token))
                    .userDataResponse(userDataResponseMapper.mapFrom(person))
                    .build();
        }
        throw new UserInfoNotFound();
    }

    @Override
    public ProfileUpdateResponse update(ProfileUpdateRequest profileUpdateRequest, HeaderParams headerParams) throws Throwable {
        Logger.getLogger(TAG).info("update " + profileUpdateRequest);
        Long accountId = authApi.sessionManager().extractUserIdFromHeader(headerParams);
        UpdateAccount updateAccount = updateAccountMapper.mapFrom(profileUpdateRequest);
        boolean update = authApi.accountManager().updateAccount(updateAccount, accountId);
        return ProfileUpdateResponse.builder()
                .success(update)
                .build();
    }

    @Override
    public UserDataResponse getUserDetails(HeaderParams headerParams) throws Throwable {
        Logger.getLogger(TAG).info("getUserDetails ");
        Long accountId = authApi.sessionManager().extractUserIdFromHeader(headerParams);
        Account account = authApi.accountManager().getAccount(accountId);
        Person person = (Person) account.getAccount();
        PersonDetails personDetails = (PersonDetails) account.getAccountDetails();
        person.setPersonDetails(personDetails);
        return userDataResponseMapper.mapFrom(person);
    }

    @Override
    public void logout(HeaderParams headerParams) throws Throwable {
        Logger.getLogger(TAG).info("logout ");

        throw new SomeThingWentWrong();
    }
}
