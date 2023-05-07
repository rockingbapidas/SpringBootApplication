package com.bapi.springbackend.auth.creation;

import com.bapi.springbackend.domain.PersonDetails;
import com.bapi.springbackend.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonDetailsUpdateAuthMapper implements IMapper<UpdateAccount, PersonDetails> {
    @Override
    public PersonDetails mapFrom(UpdateAccount updateAccount) {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFullName(updateAccount.getFullName());
        personDetails.setPhoneNo(updateAccount.getPhoneNo());
        personDetails.setPicture(updateAccount.getPicture());
        personDetails.setFirstName(updateAccount.getFirstName());
        personDetails.setLastName(updateAccount.getLastName());
        return personDetails;
    }
}
