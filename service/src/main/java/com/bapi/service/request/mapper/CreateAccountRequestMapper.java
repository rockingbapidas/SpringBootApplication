package com.bapi.service.request.mapper;

import com.bapi.auth.creation.CreateAccount;
import com.bapi.domain.IMapper;
import com.bapi.service.request.SignupRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountRequestMapper implements IMapper<SignupRequest, CreateAccount> {
    @Override
    public CreateAccount mapFrom(SignupRequest signupRequest) {
        return CreateAccount.builder()
                .setUserName(signupRequest.getUserName())
                .setFirstName(signupRequest.getFirstName())
                .setLastName(signupRequest.getLastName())
                .setFullName(signupRequest.getFullName())
                .setPassword(signupRequest.getPassword())
                .setPhoneNo(signupRequest.getPhoneNo())
                .setPicture(signupRequest.getPicture())
                .setRole("USER")
                .build();
    }

    @Override
    public SignupRequest mapTo(CreateAccount createAccount) {
        return null;
    }
}
