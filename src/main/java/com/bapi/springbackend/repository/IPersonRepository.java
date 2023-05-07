package com.bapi.springbackend.repository;

import com.bapi.springbackend.domain.Person;

public interface IPersonRepository extends IRepository<Person, Long> {
    Person findByUserName(String userName);

    Person findByUserNameAndPassword(String userName, String password);
}
