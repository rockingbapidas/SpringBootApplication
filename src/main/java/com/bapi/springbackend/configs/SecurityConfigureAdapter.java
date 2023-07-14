package com.bapi.springbackend.configs;

import com.bapi.springbackend.auth.authorization.AuthEntryPointJwt;
import com.bapi.springbackend.auth.jwt.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityConfigureAdapter extends WebSecurityConfigurerAdapter {
    private final String TAG = SecurityConfigureAdapter.class.getSimpleName();
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    @Autowired
    private AuthEntryPointJwt authEntryPointJwt;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        Logger.getLogger(TAG).info("AuthenticationManagerBuilder configure " + auth);
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        Logger.getLogger(TAG).info("HttpSecurity configure " + http);
        http.cors().and().csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPointJwt)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/login", "/signup", "/graphql", "/graphiql")
                .permitAll()
                .anyRequest()
                .authenticated();
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoderBean() {
        Logger.getLogger(TAG).info("passwordEncoderBean ");
        return NoOpPasswordEncoder.getInstance();
    }
}
