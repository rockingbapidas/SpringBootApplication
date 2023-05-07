package com.bapi.springbackend.auth.creation;

import com.bapi.springbackend.domain.Person;
import com.bapi.springbackend.domain.PersonDetails;
import com.bapi.springbackend.domain.Role;
import com.bapi.springbackend.mapper.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonAuthMapper implements IMapper<CreateAccount, Person> {
    @Autowired
    private IMapper<CreateAccount, PersonDetails> personDetailsIMapper;
    @Override
    public Person mapFrom(CreateAccount createAccount) {
        Person person = new Person();
        person.setUserName(createAccount.getUserName());
        person.setPassword(createAccount.getPassword());
        person.setRole(Role.valueOf(createAccount.getRole()));
        person.setAccountNonExpired(true);
        person.setAccountNonLocked(true);
        person.setCredentialsNonExpired(true);
        person.setPersonDetails(personDetailsIMapper.mapFrom(createAccount));
        return person;
    }
}
