package com.bapi.auth.backend.session;

import com.bapi.auth.backend.domain.Person;
import com.bapi.platform.header.HeaderParams;

public interface ISessionManager {
    Long extractUserIdFromHeader(HeaderParams headerParams);
    Person fetchUserFromHeader(HeaderParams headerParams);
    Person fetchCurrentUser();
    void deleteCurrentUser();
    boolean validateCurrentUser();
}
