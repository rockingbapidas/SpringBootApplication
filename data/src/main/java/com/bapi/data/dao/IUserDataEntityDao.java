package com.bapi.data.dao;

import com.bapi.data.entity.UserDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserDataEntityDao extends JpaRepository<UserDataEntity, Long> {
    @Query("SELECT userdata FROM UserDataEntity userdata WHERE userdata.userId = :userId")
    Optional<UserDataEntity> findUserDataByUserId(@Param("userId") Long userId);
}
