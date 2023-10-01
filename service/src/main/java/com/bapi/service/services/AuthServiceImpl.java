package com.bapi.service.services;

import com.bapi.auth.AuthApi;
import com.bapi.auth.authorization.AuthToken;
import com.bapi.auth.creation.Account;
import com.bapi.auth.creation.CreateAccount;
import com.bapi.auth.creation.UpdateAccount;
import com.bapi.auth.exception.SomeThingWentWrong;
import com.bapi.auth.exception.UserInfoNotFound;
import com.bapi.domain.IMapper;
import com.bapi.domain.Person;
import com.bapi.domain.PersonDetails;
import com.bapi.domain.Token;
import com.bapi.platform.header.HeaderParams;
import com.bapi.service.request.LoginRequest;
import com.bapi.service.request.ProfileUpdateRequest;
import com.bapi.service.request.SignupRequest;
import com.bapi.service.response.AuthResponse;
import com.bapi.service.response.ProfileUpdateResponse;
import com.bapi.service.response.TokenResponse;
import com.bapi.service.response.UserDataResponse;
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

            return new AuthResponse(
                    userDataResponseMapper.mapFrom(newPerson),
                    tokenResponseMapper.mapFrom(token)
            );
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
            return new AuthResponse(
                    userDataResponseMapper.mapFrom(person),
                    tokenResponseMapper.mapFrom(token)
            );
        }
        throw new UserInfoNotFound();
    }

    @Override
    public ProfileUpdateResponse update(ProfileUpdateRequest profileUpdateRequest, HeaderParams headerParams) throws Throwable {
        Logger.getLogger(TAG).info("update " + profileUpdateRequest);
        Long accountId = authApi.sessionManager().extractUserIdFromHeader(headerParams);
        UpdateAccount updateAccount = updateAccountMapper.mapFrom(profileUpdateRequest);
        boolean update = authApi.accountManager().updateAccount(updateAccount, accountId);
        return new ProfileUpdateResponse(update);
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
