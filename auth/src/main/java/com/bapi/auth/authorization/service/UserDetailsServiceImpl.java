package com.bapi.auth.authorization.service;

import com.bapi.data.DataApi;
import com.bapi.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private final String TAG = UserDetailsServiceImpl.class.getSimpleName();
    @Autowired
    private DataApi dataApi;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Logger.getLogger(TAG).info("loadUserByUsername " + username);
        Person person = dataApi.userRepository().findByUserName(username);
        return User.builder()
                .username(person.getUserName())
                .password(person.getPassword())
                .roles(person.getRole().toString())
                .disabled(!person.isEnabled())
                .accountExpired(!person.isAccountNonExpired())
                .accountLocked(!person.isAccountNonLocked())
                .credentialsExpired(!person.isCredentialsNonExpired())
                .build();
    }
}
