package com.bapi.springbackend.auth;

import com.bapi.springbackend.domain.Person;
import com.bapi.springbackend.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final String TAG = UserDetailsServiceImpl.class.getSimpleName();
    @Autowired
    private IPersonRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Logger.getLogger(TAG).info("loadUserByUsername " + username);
        Person person = userRepository.findByUserName(username);
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
