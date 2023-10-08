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
                .userName(signupRequest.getUserName())
                .firstName(signupRequest.getFirstName())
                .lastName(signupRequest.getLastName())
                .fullName(signupRequest.getFullName())
                .password(signupRequest.getPassword())
                .phoneNo(signupRequest.getPhoneNo())
                .picture(signupRequest.getPicture())
                .role("USER")
                .build();
    }

    @Override
    public SignupRequest mapTo(CreateAccount createAccount) {
        return null;
    }
}
