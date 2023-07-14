package com.bapi.springbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserDataEntityDao extends JpaRepository<UserDataEntity, Long> {
    @Query("SELECT userdata FROM UserDataEntity userdata WHERE userdata.userId = :userId")
    Optional<UserDataEntity> findUserDataByUserId(@Param("userId") Long userId);
}
