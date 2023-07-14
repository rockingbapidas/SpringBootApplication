package com.bapi.springbackend.repository;

import com.bapi.springbackend.dao.IUserDataEntityDao;
import com.bapi.springbackend.dao.IUserEntityDao;
import com.bapi.springbackend.dao.UserDataEntity;
import com.bapi.springbackend.dao.UserEntity;
import com.bapi.springbackend.domain.Person;
import com.bapi.springbackend.domain.PersonDetails;
import com.bapi.springbackend.mapper.IMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class PersonRepository implements IPersonRepository {
    private final String TAG = PersonRepository.class.getSimpleName();
    @Autowired
    private IUserEntityDao userEntityDao;
    @Autowired
    private IUserDataEntityDao userDetailsEntityDao;

    @Autowired
    private IMapper<Person, UserEntity> userEntityIMapper;
    @Autowired
    private IMapper<UserEntity, Person> userEntityPersonIMapper;

    @Autowired
    private IMapper<PersonDetails, UserDataEntity> userDataEntityIMapper;
    @Autowired
    private IMapper<UserDataEntity, PersonDetails> userDataEntityPersonDetailsIMapper;

    @Override
    public Person findById(Long id) {
        Logger.getLogger(TAG).info("findById " + id);
        Optional<UserEntity> userEntity = userEntityDao.findById(id);
        return userEntity.map(this::mapToPerson).orElse(null);
    }

    @Override
    public List<Person> findAll() {
        Logger.getLogger(TAG).info("findAll ");
        return new ArrayList<>(userEntityDao.findAll()).stream()
                .map(this::mapToPerson)
                .collect(Collectors.toList());
    }

    @Override
    public Person save(Person person) {
        Logger.getLogger(TAG).info("save " + person);
        return saveOrUpdate(person, false);
    }

    @Override
    public Person update(Person person, String... params) {
        Logger.getLogger(TAG).info("update " + person + " " + Arrays.toString(params));
        return saveOrUpdate(person, true);
    }

    @Transactional
    private Person saveOrUpdate(Person person, boolean isUpdate) {
        Logger.getLogger(TAG).info("saveOrUpdate " + person + " " + isUpdate);
        UserEntity userEntity = userEntityIMapper.mapFrom(person);
        UserDataEntity userDataEntity = userDataEntityIMapper.mapFrom(person.getPersonDetails());
        if (isUpdate) {
            userEntity.setUserId(person.getId());
            userDataEntity.setId(person.getPersonDetails().getId());
            userDataEntity.setUserId(person.getId());
            UserEntity newUserEntity = userEntityDao.save(userEntity);
            UserDataEntity newUserDataEntity = userDetailsEntityDao.save(userDataEntity);
            return userEntityPersonIMapper.mapFrom(newUserEntity);
        } else {
            UserEntity newUserEntity = userEntityDao.save(userEntity);
            userDataEntity.setUserId(newUserEntity.getUserId());
            UserDataEntity newUserDataEntity = userDetailsEntityDao.save(userDataEntity);
            return userEntityPersonIMapper.mapFrom(newUserEntity);
        }
    }

    @Override
    @Transactional
    public void delete(Person person) {
        Logger.getLogger(TAG).info("delete " + person);
        userDetailsEntityDao.deleteById(person.getId());
        userEntityDao.deleteById(person.getId());
    }

    @Override
    public Person findByUserName(String userName) {
        Logger.getLogger(TAG).info("findByUserName " + userName);
        return userEntityDao.findByUserName(userName).map(this::mapToPerson).orElse(null);
    }

    @Override
    public Person findByUserNameAndPassword(String userName, String password) {
        Logger.getLogger(TAG).info("findByUserNameAndPassword " + userName + " " + password);
        return userEntityDao.findByUserNameAndPassword(userName, password)
                .map(this::mapToPerson)
                .orElse(null);
    }

    @NotNull
    private Person mapToPerson(UserEntity userEntity) {
        Logger.getLogger(TAG).info("mapToPerson " + userEntity);
        Person person = userEntityPersonIMapper.mapFrom(userEntity);
        PersonDetails personDetails = fetchPersonDetails(userEntity.getUserId());
        person.setPersonDetails(personDetails);
        return person;
    }

    private PersonDetails fetchPersonDetails(Long userId) {
        Logger.getLogger(TAG).info("mapToPersonDetails " + userId);
        UserDataEntity userDataEntity = userDetailsEntityDao.findUserDataByUserId(userId).orElse(null);
        return userDataEntityPersonDetailsIMapper.mapFrom(userDataEntity);
    }
}
