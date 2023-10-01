package com.bapi.data.dao;

import com.bapi.data.entity.IdTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdTokenEntityDao extends JpaRepository<IdTokenEntity, Long> {
    @Query("SELECT token FROM IdTokenEntity token WHERE token.deviceUniqueId = :deviceId and token.userName = :username")
    Optional<IdTokenEntity> findTokenByUserNameAndDeviceId(@Param("deviceId") String deviceId, @Param("username") String userName);
}
