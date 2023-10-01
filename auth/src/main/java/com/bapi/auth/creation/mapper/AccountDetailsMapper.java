package com.bapi.auth.creation.mapper;

import com.bapi.auth.creation.CreateAccount;
import com.bapi.domain.IMapper;
import com.bapi.domain.PersonDetails;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailsMapper implements IMapper<CreateAccount, PersonDetails> {
    @Override
    public PersonDetails mapFrom(CreateAccount createAccount) {
        return new PersonDetails(
                createAccount.getFullName(),
                createAccount.getPhoneNo(),
                createAccount.getPicture(),
                createAccount.getFirstName(),
                createAccount.getLastName()
        );
    }

    @Override
    public CreateAccount mapTo(PersonDetails personDetails) {
        return CreateAccount.builder()
                .setFirstName(personDetails.getFirstName())
                .setLastName(personDetails.getLastName())
                .setFullName(personDetails.getFullName())
                .setPhoneNo(personDetails.getPhoneNo())
                .setPicture(personDetails.getPicture())
                .build();
    }
}
