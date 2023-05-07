package com.bapi.springbackend.domain.mapper;

import com.bapi.springbackend.dao.UserDataEntity;
import com.bapi.springbackend.domain.PersonDetails;
import com.bapi.springbackend.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonDetailsMapper implements IMapper<UserDataEntity, PersonDetails> {
    @Override
    public PersonDetails mapFrom(UserDataEntity userDetails) {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setId(userDetails.getId());
        personDetails.setFirstName(userDetails.getFirstName());
        personDetails.setLastName(userDetails.getLastName());
        personDetails.setFullName(userDetails.getFullName());
        personDetails.setPicture(userDetails.getPicture());
        personDetails.setPhoneNo(userDetails.getPhoneNo());
        return personDetails;
    }
}
