package com.bapi.springbackend.request.mapper;

import com.bapi.springbackend.auth.creation.CreateAccount;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.request.SignupRequest;
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
}
