package com.bapi.data.repository;

import com.bapi.data.repository.base.IRepository;
import com.bapi.domain.Person;

public interface IUserRepository extends IRepository<Person, Long> {
    Person findByUserName(String userName);

    Person findByUserNameAndPassword(String userName, String password);
}
