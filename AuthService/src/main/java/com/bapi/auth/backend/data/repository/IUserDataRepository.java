package com.bapi.auth.backend.data.repository;

import com.bapi.auth.backend.data.repository.base.IRepository;
import com.bapi.auth.backend.domain.PersonDetails;

public interface IUserDataRepository extends IRepository<PersonDetails, String> {
    PersonDetails findByUserId(Long userId);
}
