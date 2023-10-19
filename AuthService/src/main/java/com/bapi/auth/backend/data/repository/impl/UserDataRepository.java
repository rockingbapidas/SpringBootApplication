package com.bapi.auth.backend.data.repository.impl;

import com.bapi.auth.backend.data.entity.UserDataEntity;
import com.bapi.auth.backend.data.repository.IUserDataRepository;
import com.bapi.auth.backend.data.source.IUserDetailsDataSource;
import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.PersonDetails;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class UserDataRepository implements IUserDataRepository {
    private final String TAG = UserDataRepository.class.getSimpleName();

    @Autowired
    private IUserDetailsDataSource userDataEntityDao;

    @Autowired
    private IMapper<PersonDetails, UserDataEntity> userDataEntityIMapper;

    @Override
    public PersonDetails findById(String id) {
        Logger.getLogger(TAG).info("findById " + id);
        return userDataEntityDao.findById(id).map(userDataEntityIMapper::mapTo).orElse(null);
    }

    @Override
    public List<PersonDetails> findAll() {
        Logger.getLogger(TAG).info("findAll ");
        return userDataEntityDao.findAll().stream().map(userDataEntityIMapper::mapTo).collect(Collectors.toList());
    }

    @Override
    public PersonDetails save(PersonDetails userDataEntity) {
        Logger.getLogger(TAG).info("save " + userDataEntity);
        UserDataEntity entity = userDataEntityIMapper.mapFrom(userDataEntity);
        UserDataEntity updateEntity = userDataEntityDao.save(entity);
        return userDataEntityIMapper.mapTo(updateEntity);
    }

    @Override
    @Transactional
    public PersonDetails update(PersonDetails userDataEntity, String... params) {
        Logger.getLogger(TAG).info("update " + userDataEntity + " " + Arrays.toString(params));
        UserDataEntity entity = userDataEntityIMapper.mapFrom(userDataEntity);
        UserDataEntity updateEntity = userDataEntityDao.save(entity);
        return userDataEntityIMapper.mapTo(updateEntity);
    }

    @Override
    public boolean delete(PersonDetails userDataEntity) {
        Logger.getLogger(TAG).info("delete " + userDataEntity);
        UserDataEntity entity = userDataEntityIMapper.mapFrom(userDataEntity);
        userDataEntityDao.delete(entity);
        return true;
    }

    @Override
    public PersonDetails findByUserId(Long userId) {
        Logger.getLogger(TAG).info("findByUserId " + userId);
        return userDataEntityDao.findByUserId(userId).map(userDataEntityIMapper::mapTo).orElse(null);
    }
}
