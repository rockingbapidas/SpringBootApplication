package com.bapi.data.repository.base;

import java.util.List;

public interface IRepository<MODEL, KEY> {
    MODEL findById(KEY id);

    List<MODEL> findAll();

    MODEL save(MODEL model);

    MODEL update(MODEL model, String... params);

    boolean delete(MODEL model);
}
