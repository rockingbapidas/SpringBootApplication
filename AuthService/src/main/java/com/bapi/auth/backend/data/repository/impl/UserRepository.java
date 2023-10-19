package com.bapi.auth.backend.data.repository.impl;

import com.bapi.auth.backend.data.entity.UserEntity;
import com.bapi.auth.backend.data.repository.IUserRepository;
import com.bapi.auth.backend.data.source.IUserDataSource;
import com.bapi.auth.backend.domain.IMapper;
import com.bapi.auth.backend.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {
    private final String TAG = UserRepository.class.getSimpleName();

    @Autowired
    private IUserDataSource userEntityDao;

    @Autowired
    private IMapper<Person, UserEntity> userEntityIMapper;

    @Override
    public Person findById(Long id) {
        Logger.getLogger(TAG).info("findById " + id);
        return userEntityDao.findById(id).map(userEntityIMapper::mapTo).orElse(null);
    }

    @Override
    public List<Person> findAll() {
        Logger.getLogger(TAG).info("findAll ");
        return userEntityDao.findAll().stream().map(userEntityIMapper::mapTo).collect(Collectors.toList());
    }

    @Override
    public Person save(Person person) {
        Logger.getLogger(TAG).info("save " + person);
        UserEntity entity = userEntityIMapper.mapFrom(person);
        UserEntity updateEntity = userEntityDao.save(entity);
        return userEntityIMapper.mapTo(updateEntity);
    }

    @Override
    public Person update(Person person, String... params) {
        Logger.getLogger(TAG).info("update " + person);
        return userEntityIMapper.mapTo(userEntityDao.save(userEntityIMapper.mapFrom(person)));
    }

    @Override
    public boolean delete(Person person) {
        Logger.getLogger(TAG).info("delete " + person);
        userEntityDao.delete(userEntityIMapper.mapFrom(person));
        return true;
    }

    @Override
    public Person findByUserName(String userName) {
        Logger.getLogger(TAG).info("findByUserName " + userName);
        return userEntityDao.findByUserName(userName).map(userEntityIMapper::mapTo).orElse(null);
    }

    @Override
    public Person findByUserNameAndPassword(String userName, String password) {
        Logger.getLogger(TAG).info("findByUserNameAndPassword " + userName + " " + password);
        return userEntityDao.findByUserNameAndPassword(userName, password).map(userEntityIMapper::mapTo).orElse(null);
    }
}
