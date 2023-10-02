package com.bapi.auth.session;

import com.bapi.auth.jwt.IJwtAuthManager;
import com.bapi.data.DataApi;
import com.bapi.domain.Person;
import com.bapi.platform.header.HeaderParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class SessionManager implements ISessionManager {
    private final String TAG = SessionManager.class.getSimpleName();
    @Autowired
    private DataApi dataApi;
    @Autowired
    private IJwtAuthManager jwtAuthService;

    @Override
    public Long extractUserIdFromHeader(HeaderParams headerParams) {
        Logger.getLogger(TAG).info("extractUserIdFromHeader " + headerParams);
        String authorizationHeader = headerParams.getAccessToken();
        String userName = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            userName = jwtAuthService.extractUsername(token);
        }
        if (userName != null) {
            Person person = dataApi.userRepository().findByUserName(userName);
            return person.getId();
        }
        return null;
    }

    @Override
    public Person fetchUserFromHeader(HeaderParams headerParams) {
        String authorizationHeader = headerParams.getAccessToken();
        String userName = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            userName = jwtAuthService.extractUsername(token);
        }
        if (userName != null) {
            return dataApi.userRepository().findByUserName(userName);
        }
        return null;
    }

    @Override
    public Person fetchCurrentUser() {
        Logger.getLogger(TAG).info("fetchCurrentUser ");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String username = authentication.getPrincipal().toString();
            if (username != null) {
                return dataApi.userRepository().findByUserName(username);
            }
        }
        return null;
    }

    @Override
    public void deleteCurrentUser() {
        Logger.getLogger(TAG).info("deleteCurrentUser ");
        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();
    }

    @Override
    public boolean validateCurrentUser() {
        Logger.getLogger(TAG).info("validateCurrentUser ");
        return SecurityContextHolder.getContext().getAuthentication() != null;
    }
}
