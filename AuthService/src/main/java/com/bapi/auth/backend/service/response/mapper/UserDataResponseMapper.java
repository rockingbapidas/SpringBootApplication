package com.bapi.auth.backend.service.response.mapper;

import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.Person;
import com.bapi.auth.backend.service.response.UserDataResponse;
import org.springframework.stereotype.Component;

@Component
public class UserDataResponseMapper implements IMapper<Person, UserDataResponse> {
    @Override
    public UserDataResponse mapFrom(Person person) {
        return UserDataResponse.builder()
                .userId(person.getId())
                .email(person.getUserName())
                .fullName(person.getPersonDetails().getFullName())
                .firstName(person.getPersonDetails().getFirstName())
                .lastName(person.getPersonDetails().getLastName())
                .phoneNo(person.getPersonDetails().getPhoneNo())
                .picture(person.getPersonDetails().getPicture())
                .build();
    }

    @Override
    public Person mapTo(UserDataResponse userDataResponse) {
        return null;
    }
}
