package com.bapi.service.response.mapper;

import com.bapi.domain.IMapper;
import com.bapi.domain.Person;
import com.bapi.service.response.UserDataResponse;
import org.springframework.stereotype.Component;

@Component
public class UserDataResponseMapper implements IMapper<Person, UserDataResponse> {
    @Override
    public UserDataResponse mapFrom(Person person) {
        return new UserDataResponse(
                person.getId(),
                person.getUserName(),
                person.getPersonDetails().getFullName(),
                person.getPersonDetails().getPhoneNo(),
                person.getPersonDetails().getPicture(),
                person.getPersonDetails().getFirstName(),
                person.getPersonDetails().getLastName()
        );
    }

    @Override
    public Person mapTo(UserDataResponse userDataResponse) {
        return null;
    }
}
