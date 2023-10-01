package com.bapi.data.mapper;

import com.bapi.data.entity.UserEntity;
import com.bapi.domain.IMapper;
import com.bapi.domain.Person;
import com.bapi.domain.Role;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper implements IMapper<Person, UserEntity> {
    @Override
    public UserEntity mapFrom(Person person) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(person.getUserName());
        userEntity.setPassword(person.getPassword());
        userEntity.setRole(person.getRole().name());
        userEntity.setEnabled(person.isEnabled());
        userEntity.setAccountNonExpired(person.isAccountNonExpired());
        userEntity.setAccountNonLocked(person.isAccountNonLocked());
        userEntity.setCredentialsNonExpired(person.isCredentialsNonExpired());
        return userEntity;
    }

    @Override
    public Person mapTo(UserEntity userEntity) {
        return new Person(
                userEntity.getUserId(),
                userEntity.getUserName(),
                userEntity.getPassword(),
                Role.valueOf(userEntity.getRole()),
                userEntity.isAccountNonExpired(),
                userEntity.isCredentialsNonExpired(),
                userEntity.isAccountNonLocked(),
                userEntity.isEnabled()
        );
    }
}
