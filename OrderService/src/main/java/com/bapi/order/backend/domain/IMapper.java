package com.bapi.order.backend.domain;

public interface IMapper<FROM, TO> {
    TO mapFrom(FROM from);

    FROM mapTo(TO to);
}
