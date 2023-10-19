package com.bapi.auth.backend.domain;

public interface IMapper<FROM, TO> {
    TO mapFrom(FROM from);

    FROM mapTo(TO to);
}
