package com.bapi.auth.creation.mapper;

import com.bapi.auth.creation.CreateAccount;
import com.bapi.domain.IMapper;
import com.bapi.domain.Person;
import com.bapi.domain.Role;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountMapper implements IMapper<CreateAccount, Person> {
    @Override
    public Person mapFrom(CreateAccount createAccount) {
        return new Person(
                createAccount.getUserName(),
                createAccount.getPassword(),
                Role.valueOf(createAccount.getRole()),
                true,
                true,
                true,
                true
        );
    }

    @Override
    public CreateAccount mapTo(Person person) {
        return CreateAccount.builder()
                .setUserName(person.getUserName())
                .setPassword(person.getPassword())
                .setRole(person.getRole().name())
                .build();
    }
}
