package com.bapi.data.source;

import com.bapi.data.entity.UserDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserDetailsDataSource extends MongoRepository<UserDataEntity, String> {
    Optional<UserDataEntity> findByUserId(Long userId);
}
