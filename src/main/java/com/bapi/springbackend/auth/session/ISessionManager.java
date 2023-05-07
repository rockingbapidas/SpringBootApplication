package com.bapi.springbackend.auth.session;

import com.bapi.springbackend.auth.header.HeaderParams;
import com.bapi.springbackend.domain.Person;

public interface ISessionManager {
    Long extractUserIdFromHeader(HeaderParams headerParams);
    Person fetchUserFromHeader(HeaderParams headerParams);
    Person fetchCurrentUser();
    void deleteCurrentUser();
    boolean validateCurrentUser();
}
