package com.bapi.springbackend.auth.authorization;

import com.bapi.springbackend.domain.Person;
import com.bapi.springbackend.exceptions.InvalidCredential;
import com.bapi.springbackend.repository.IPersonRepository;
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
    private IPersonRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Logger.getLogger(TAG).info("authenticate " + authentication);
        Person person = userRepository.findByUserNameAndPassword(authentication.getPrincipal().toString(),
                authentication.getCredentials().toString());
        if (person == null) throw new InvalidCredential();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authentication.getPrincipal(),
                authentication.getCredentials(),
                Collections.emptyList());
        authenticationToken.setDetails(person);
        return authenticationToken;
    }
}