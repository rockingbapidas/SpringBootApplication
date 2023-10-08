package com.bapi.data.repository;

import com.bapi.data.repository.base.IRepository;
import com.bapi.domain.PersonDetails;

public interface IUserDataRepository extends IRepository<PersonDetails, String> {
    PersonDetails findByUserId(Long userId);
}
