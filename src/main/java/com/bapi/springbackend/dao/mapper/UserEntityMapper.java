package com.bapi.springbackend.dao.mapper;

import com.bapi.springbackend.dao.UserEntity;
import com.bapi.springbackend.domain.Person;
import com.bapi.springbackend.mapper.IMapper;
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
}
