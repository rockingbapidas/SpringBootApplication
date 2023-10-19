package com.bapi.auth.backend;

import com.bapi.auth.backend.jwt.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.logging.Logger;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
@EnableConfigurationProperties(SecurityProperties.class)
public class CustomSecurityConfigureAdapter {
    private final String TAG = CustomSecurityConfigureAdapter.class.getSimpleName();
    @Autowired
    private UserDetailsService userDetailService;
    @Autowired
    private AuthenticationEntryPoint authenticationEntrypoint;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        Logger.getLogger(TAG).info("DaoAuthenticationProvider authenticationProvider ");
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService);
        authProvider.setPasswordEncoder(passwordEncoderBean());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        Logger.getLogger(TAG).info("AuthenticationManager authenticationManager ");
        return authConfig.authenticationManagerBuilder().build();
    }

    @Bean
    public PasswordEncoder passwordEncoderBean() {
        Logger.getLogger(TAG).info("PasswordEncoder passwordEncoderBean ");
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    public PasswordEncoder passwordEncoderBean() {
        Logger.getLogger(TAG).info("passwordEncoderBean ");
        return NoOpPasswordEncoder.getInstance();
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        Logger.getLogger(TAG).info("SecurityFilterChain filterChain " + http);
        http.cors(AbstractHttpConfigurer::disable).csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntrypoint))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/test/**").permitAll()
                        .requestMatchers("/graphql", "/graphiql").permitAll()
                        .anyRequest()
                        .authenticated()
                );
        http.authenticationManager(auth -> authenticationManager(authenticationManager));
        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
