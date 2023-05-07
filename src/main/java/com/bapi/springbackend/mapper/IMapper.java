package com.bapi.springbackend.mapper;

public interface IMapper<FROM, TO>{
    TO mapFrom(FROM from);
}
