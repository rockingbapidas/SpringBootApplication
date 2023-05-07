package com.bapi.springbackend.auth.creation;

import com.bapi.springbackend.domain.PersonDetails;
import com.bapi.springbackend.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonDetailsAuthMapper implements IMapper<CreateAccount, PersonDetails> {
    @Override
    public PersonDetails mapFrom(CreateAccount createAccount) {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFullName(createAccount.getFullName());
        personDetails.setPhoneNo(createAccount.getPhoneNo());
        personDetails.setPicture(createAccount.getPicture());
        personDetails.setFirstName(createAccount.getFirstName());
        personDetails.setLastName(createAccount.getLastName());
        return personDetails;
    }
}
