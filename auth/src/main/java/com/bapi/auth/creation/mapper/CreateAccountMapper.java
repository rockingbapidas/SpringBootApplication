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
