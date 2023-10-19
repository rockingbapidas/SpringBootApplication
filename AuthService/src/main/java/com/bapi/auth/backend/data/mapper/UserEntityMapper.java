package com.bapi.auth.backend.data.mapper;

import com.bapi.auth.backend.data.entity.UserEntity;
import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.Person;
import com.bapi.auth.backend.domain.Role;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper implements IMapper<Person, UserEntity> {
    @Override
    public UserEntity mapFrom(Person person) {
        return UserEntity.builder()
                .userName(person.getUserName())
                .password(person.getPassword())
                .role(person.getRole().name())
                .enabled(person.isEnabled())
                .accountNonExpired(person.isAccountNonExpired())
                .accountNonLocked(person.isAccountNonLocked())
                .credentialsNonExpired(person.isCredentialsNonExpired())
                .build();
    }

    @Override
    public Person mapTo(UserEntity userEntity) {
        return Person.builder()
                .id(userEntity.getUserId())
                .userName(userEntity.getUserName())
                .password(userEntity.getPassword())
                .role(Role.valueOf(userEntity.getRole()))
                .accountNonExpired(userEntity.isAccountNonExpired())
                .credentialsNonExpired(userEntity.isCredentialsNonExpired())
                .accountNonLocked(userEntity.isAccountNonLocked())
                .enabled(userEntity.isEnabled())
                .build();
    }
}
