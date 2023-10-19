package com.bapi.auth.backend.authorization.service;

import com.bapi.auth.backend.authorization.exception.InvalidCredential;
import com.bapi.auth.backend.authorization.exception.UserDetailsNotFound;
import com.bapi.auth.backend.data.DataApi;
import com.bapi.auth.backend.domain.Person;
import com.bapi.auth.backend.domain.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.logging.Logger;

@Component
public class AuthenticationManagerImpl implements AuthenticationManager {
    private final String TAG = AuthenticationManagerImpl.class.getSimpleName();
    @Autowired
    private DataApi dataApi;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Logger.getLogger(TAG).info("authenticate " + authentication);
        Person person = dataApi.userRepository().findByUserNameAndPassword(authentication.getPrincipal().toString(),
                authentication.getCredentials().toString());
        if (person == null) throw new InvalidCredential();

        PersonDetails personDetails = dataApi.userDataRepository().findByUserId(person.getId());

        if (personDetails == null) throw new UserDetailsNotFound();

        person.setPersonDetails(personDetails);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authentication.getPrincipal(),
                authentication.getCredentials(),
                Collections.emptyList());
        authenticationToken.setDetails(person);
        return authenticationToken;
    }
}