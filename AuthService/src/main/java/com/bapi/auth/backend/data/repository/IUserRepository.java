package com.bapi.auth.backend.data.repository;


import com.bapi.auth.backend.data.repository.base.IRepository;
import com.bapi.auth.backend.domain.Person;

public interface IUserRepository extends IRepository<Person, Long> {
    Person findByUserName(String userName);

    Person findByUserNameAndPassword(String userName, String password);
}
