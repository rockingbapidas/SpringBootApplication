package com.bapi.springbackend.auth.creation;

import com.bapi.springbackend.domain.Person;
import com.bapi.springbackend.domain.PersonDetails;
import com.bapi.springbackend.exceptions.AccountAlreadyExist;
import com.bapi.springbackend.exceptions.AccountDoesNotExist;
import com.bapi.springbackend.exceptions.UserDetailsNotFound;
import com.bapi.springbackend.mapper.IMapper;
import com.bapi.springbackend.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AccountManager implements IAccountManager {
    private final String TAG = AccountManager.class.getSimpleName();
    @Autowired
    private IPersonRepository userRepository;
    @Autowired
    private IMapper<CreateAccount, Person> personMapper;
    @Autowired
    private IMapper<CreateAccount, PersonDetails> personDetailsMapper;

    @Override
    public Account createAccount(CreateAccount createAccount) throws Throwable {
        Logger.getLogger(TAG).info("create " + createAccount);
        if (userRepository.findByUserName(createAccount.getUserName()) == null) {
            Person newPerson = personMapper.mapFrom(createAccount);
            userRepository.save(newPerson);
            Person savedPerson = userRepository.findByUserName(createAccount.getUserName());
            return Account.builder()
                    .setCreated(true)
                    .setCreatedAt(System.currentTimeMillis())
                    .setAccountDetails(savedPerson)
                    .build();
        }
        throw new AccountAlreadyExist();
    }

    @Override
    public boolean updateAccount(UpdateAccount updateAccount, Long accountId) throws Throwable {
        Logger.getLogger(TAG).info("updateAccount " + updateAccount);
        Person person = userRepository.findById(accountId);
        if (person != null) {
            PersonDetails personDetails = person.getPersonDetails();
            if (updateAccount.getFirstName() != null) {
                personDetails.setFirstName(updateAccount.getFirstName());
            }
            if (updateAccount.getLastName() != null) {
                personDetails.setLastName(updateAccount.getLastName());
            }
            if (updateAccount.getFullName() != null) {
                personDetails.setFullName(updateAccount.getFullName());
            }
            if (updateAccount.getPicture() != null) {
                personDetails.setPicture(updateAccount.getPicture());
            }
            if (updateAccount.getPhoneNo() != null) {
                personDetails.setPhoneNo(updateAccount.getPhoneNo());
            }
            person.setPersonDetails(personDetails);
            userRepository.update(person);
            return true;
        }
        throw new AccountDoesNotExist();
    }

    @Override
    public boolean deleteAccount(Long accountId) throws Throwable {
        Logger.getLogger(TAG).info("deleteAccount " + accountId);
        Person person = userRepository.findById(accountId);
        if (person != null) {
            userRepository.delete(person);
            return true;
        }
        throw new AccountDoesNotExist();
    }
}
