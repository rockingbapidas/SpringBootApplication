package com.bapi.springbackend.dao.mapper;

import com.bapi.springbackend.dao.UserDataEntity;
import com.bapi.springbackend.domain.PersonDetails;
import com.bapi.springbackend.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDataEntityMapper implements IMapper<PersonDetails, UserDataEntity> {
    @Override
    public UserDataEntity mapFrom(PersonDetails personDetails) {
        UserDataEntity userDataEntity = new UserDataEntity();
        userDataEntity.setFirstName(personDetails.getFirstName());
        userDataEntity.setLastName(personDetails.getLastName());
        userDataEntity.setFullName(personDetails.getFullName());
        userDataEntity.setPicture(personDetails.getPicture());
        userDataEntity.setPhoneNo(personDetails.getPhoneNo());
        return userDataEntity;
    }
}
