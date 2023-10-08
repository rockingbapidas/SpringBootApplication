package com.bapi.auth.creation.mapper;

import com.bapi.auth.creation.CreateAccount;
import com.bapi.domain.IMapper;
import com.bapi.domain.PersonDetails;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailsMapper implements IMapper<CreateAccount, PersonDetails> {
    @Override
    public PersonDetails mapFrom(CreateAccount createAccount) {
        return PersonDetails.builder()
                .firstName(createAccount.getFirstName())
                .lastName(createAccount.getLastName())
                .fullName(createAccount.getFullName())
                .phoneNo(createAccount.getPhoneNo())
                .picture(createAccount.getPicture())
                .build();
    }

    @Override
    public CreateAccount mapTo(PersonDetails personDetails) {
        return CreateAccount.builder()
                .firstName(personDetails.getFirstName())
                .lastName(personDetails.getLastName())
                .fullName(personDetails.getFullName())
                .phoneNo(personDetails.getPhoneNo())
                .picture(personDetails.getPicture())
                .build();
    }
}
