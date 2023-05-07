package com.bapi.springbackend.response.mapper;

import com.bapi.springbackend.domain.Person;
import com.bapi.springbackend.domain.PersonDetails;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.response.UserDataResponse;
import org.springframework.stereotype.Component;

@Component
public class UserDataResponseMapper implements IMapper<Person, UserDataResponse> {
    @Override
    public UserDataResponse mapFrom(Person person) {
        PersonDetails personDetails = person.getPersonDetails();
        return new UserDataResponse(
                person.getId(),
                person.getUserName(),
                personDetails.getFullName(),
                personDetails.getPhoneNo(),
                personDetails.getPicture(),
                personDetails.getFirstName(),
                personDetails.getLastName()
        );
    }
}
