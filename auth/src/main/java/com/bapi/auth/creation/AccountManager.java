package com.bapi.auth.creation;

import com.bapi.auth.creation.exception.AccountAlreadyExist;
import com.bapi.auth.creation.exception.AccountDoesNotExist;
import com.bapi.data.DataApi;
import com.bapi.domain.IMapper;
import com.bapi.domain.Person;
import com.bapi.domain.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AccountManager implements IAccountManager {
    private final String TAG = AccountManager.class.getSimpleName();
    @Autowired
    private DataApi dataApi;
    @Autowired
    private IMapper<CreateAccount, Person> createAccountMapper;
    @Autowired
    private IMapper<CreateAccount, PersonDetails> accountDetailsMapper;

    @Override
    public Account createAccount(CreateAccount createAccount) throws Throwable {
        Logger.getLogger(TAG).info("create " + createAccount);
        if (dataApi.userRepository().findByUserName(createAccount.getUserName()) == null) {

            Person person = createAccountMapper.mapFrom(createAccount);
            Person savedPerson = dataApi.userRepository().save(person);

            PersonDetails personDetails = accountDetailsMapper.mapFrom(createAccount);
            personDetails.setUserId(savedPerson.getId());
            PersonDetails savedPersonDetails = dataApi.userDataRepository().save(personDetails);

            return Account.builder()
                    .setCreated(true)
                    .setCreatedAt(System.currentTimeMillis())
                    .setAccount(savedPerson)
                    .setAccountDetails(savedPersonDetails)
                    .build();
        }
        throw new AccountAlreadyExist();
    }

    @Override
    public boolean updateAccount(UpdateAccount updateAccount, Long accountId) throws Throwable {
        Logger.getLogger(TAG).info("updateAccount " + updateAccount);
        PersonDetails personDetails = dataApi.userDataRepository().findByUserId(accountId);
        if (personDetails != null) {
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
            PersonDetails updatedPersonDetails = dataApi.userDataRepository().update(personDetails, String.valueOf(accountId));
            return updatedPersonDetails != null;
        }
        throw new AccountDoesNotExist();
    }

    @Override
    public Account getAccount(Long accountId) throws Throwable {
        Logger.getLogger(TAG).info("getAccount " + accountId);
        Person person = dataApi.userRepository().findById(accountId);
        if (person != null) {
            PersonDetails personDetails = dataApi.userDataRepository().findByUserId(accountId);
            return Account.builder()
                    .setCreated(true)
                    .setCreatedAt(System.currentTimeMillis())
                    .setAccount(person)
                    .setAccountDetails(personDetails)
                    .build();
        }
        throw new AccountDoesNotExist();
    }

    @Override
    public boolean deleteAccount(Long accountId) throws Throwable {
        Logger.getLogger(TAG).info("deleteAccount " + accountId);
        Person person = dataApi.userRepository().findById(accountId);
        PersonDetails personDetails = dataApi.userDataRepository().findByUserId(accountId);
        if (person != null) {
            dataApi.userRepository().delete(person);
            dataApi.userDataRepository().delete(personDetails);
            return true;
        }
        throw new AccountDoesNotExist();
    }
}
