package com.bapi.auth.backend.data.mapper;

import com.bapi.auth.backend.data.entity.UserDataEntity;
import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.PersonDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDataEntityMapper implements IMapper<PersonDetails, UserDataEntity> {
    @Override
    public UserDataEntity mapFrom(PersonDetails personDetails) {
        return UserDataEntity.builder()
                .id(personDetails.getId())
                .userId(personDetails.getUserId())
                .version(personDetails.getVersion())
                .firstName(personDetails.getFirstName())
                .lastName(personDetails.getLastName())
                .fullName(personDetails.getFullName())
                .picture(personDetails.getPicture())
                .phoneNo(personDetails.getPhoneNo())
                .build();
    }

    @Override
    public PersonDetails mapTo(UserDataEntity userDataEntity) {
        return PersonDetails.builder()
                .id(userDataEntity.getId())
                .userId(userDataEntity.getUserId())
                .version(userDataEntity.getVersion())
                .firstName(userDataEntity.getFirstName())
                .lastName(userDataEntity.getLastName())
                .fullName(userDataEntity.getFullName())
                .picture(userDataEntity.getPicture())
                .phoneNo(userDataEntity.getPhoneNo())
                .build();
    }
}
