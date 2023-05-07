package com.bapi.springbackend.domain.mapper;

import com.bapi.springbackend.dao.UserEntity;
import com.bapi.springbackend.domain.Person;
import com.bapi.springbackend.domain.Role;
import com.bapi.springbackend.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements IMapper<UserEntity, Person> {
    @Override
    public Person mapFrom(UserEntity userEntity) {
        Person person = new Person();
        person.setId(userEntity.getUserId());
        person.setUserName(userEntity.getUserName());
        person.setPassword(userEntity.getPassword());
        person.setRole(Role.valueOf(userEntity.getRole()));
        person.setEnabled(userEntity.isEnabled());
        person.setAccountNonExpired(userEntity.isAccountNonExpired());
        person.setAccountNonLocked(userEntity.isAccountNonLocked());
        person.setCredentialsNonExpired(userEntity.isCredentialsNonExpired());
        return person;
    }
}
