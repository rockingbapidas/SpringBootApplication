package com.bapi.springbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IdTokenEntityDao extends JpaRepository<IdTokenEntity, String> {
    @Query("SELECT token FROM IdTokenEntity token WHERE token.deviceUniqueId = :deviceId and token.userName = :username")
    Optional<IdTokenEntity> findTokenByUserNameAndDeviceId(@Param("deviceId") String deviceId, @Param("username") String userName);
}
