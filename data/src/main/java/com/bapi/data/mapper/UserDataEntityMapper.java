package com.bapi.data.mapper;

import com.bapi.data.entity.UserDataEntity;
import com.bapi.domain.IMapper;
import com.bapi.domain.PersonDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDataEntityMapper implements IMapper<PersonDetails, UserDataEntity> {
    @Override
    public UserDataEntity mapFrom(PersonDetails personDetails) {
        UserDataEntity userDataEntity = new UserDataEntity();

        userDataEntity.setId(personDetails.getId());
        userDataEntity.setUserId(personDetails.getUserId());
        userDataEntity.setVersion(personDetails.getVersion());

        userDataEntity.setFirstName(personDetails.getFirstName());
        userDataEntity.setLastName(personDetails.getLastName());
        userDataEntity.setFullName(personDetails.getFullName());
        userDataEntity.setPicture(personDetails.getPicture());
        userDataEntity.setPhoneNo(personDetails.getPhoneNo());

        return userDataEntity;
    }

    @Override
    public PersonDetails mapTo(UserDataEntity userDataEntity) {
        return new PersonDetails(
                userDataEntity.getId(),
                userDataEntity.getUserId(),
                userDataEntity.getVersion(),
                userDataEntity.getFullName(),
                userDataEntity.getPhoneNo(),
                userDataEntity.getPicture(),
                userDataEntity.getFirstName(),
                userDataEntity.getLastName()
        );
    }
}
