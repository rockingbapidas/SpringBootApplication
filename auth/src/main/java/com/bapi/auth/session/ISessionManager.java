package com.bapi.auth.session;

import com.bapi.domain.Person;
import com.bapi.platform.header.HeaderParams;

public interface ISessionManager {
    Long extractUserIdFromHeader(HeaderParams headerParams);
    Person fetchUserFromHeader(HeaderParams headerParams);
    Person fetchCurrentUser();
    void deleteCurrentUser();
    boolean validateCurrentUser();
}
