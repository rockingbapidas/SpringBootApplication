package com.bapi.springbackend.repository;

import java.util.List;

public interface IRepository<MODEL, KEY> {
    MODEL findById(KEY id);

    List<MODEL> findAll();

    MODEL save(MODEL model);

    MODEL update(MODEL model, String... params);

    void delete(MODEL model);
}
