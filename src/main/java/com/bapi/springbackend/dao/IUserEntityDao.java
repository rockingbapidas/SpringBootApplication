package com.bapi.springbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserEntityDao extends JpaRepository<UserEntity, Long> {
    @Query("SELECT user FROM UserEntity user WHERE user.userName = :username")
    Optional<UserEntity> findByUserName(@Param("username") String userName);

    @Query(value = "SELECT user FROM UserEntity user WHERE user.userName = :username and user.password = :password")
    Optional<UserEntity> findByUserNameAndPassword(@Param("username") String userName, @Param("password") String password);
}
