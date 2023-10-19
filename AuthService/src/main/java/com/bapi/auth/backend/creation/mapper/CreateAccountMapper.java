package com.bapi.auth.backend.creation.mapper;

import com.bapi.auth.backend.creation.CreateAccount;
import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.Person;
import com.bapi.auth.backend.domain.Role;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountMapper implements IMapper<CreateAccount, Person> {
    @Override
    public Person mapFrom(CreateAccount createAccount) {
        return Person.builder()
                .userName(createAccount.getUserName())
                .password(createAccount.getPassword())
                .role(Role.valueOf(createAccount.getRole()))
                .accountNonLocked(true)
                .accountNonExpired(true)
                .enabled(true)
                .credentialsNonExpired(true)
                .build();
    }

    @Override
    public CreateAccount mapTo(Person person) {
        return CreateAccount.builder()
                .userName(person.getUserName())
                .password(person.getPassword())
                .role(person.getRole().name())
                .build();
    }
}
