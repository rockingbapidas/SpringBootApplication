package com.bapi.springbackend.request.mapper;

import com.bapi.springbackend.auth.creation.CreateAccount;
import com.bapi.springbackend.auth.creation.UpdateAccount;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.request.ProfileUpdateRequest;
import com.bapi.springbackend.request.SignupRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccountRequestMapper implements IMapper<ProfileUpdateRequest, UpdateAccount> {
    @Override
    public UpdateAccount mapFrom(ProfileUpdateRequest profileUpdateRequest) {
        return UpdateAccount.builder()
                .setFirstName(profileUpdateRequest.getFirstName())
                .setLastName(profileUpdateRequest.getLastName())
                .setFullName(profileUpdateRequest.getFullName())
                .setPhoneNo(profileUpdateRequest.getPhoneNo())
                .setPicture(profileUpdateRequest.getPicture())
                .build();
    }
}
