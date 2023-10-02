package com.bapi.service.request.mapper;

import com.bapi.auth.creation.UpdateAccount;
import com.bapi.domain.IMapper;
import com.bapi.service.request.ProfileUpdateRequest;
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

    @Override
    public ProfileUpdateRequest mapTo(UpdateAccount updateAccount) {
        return null;
    }
}
