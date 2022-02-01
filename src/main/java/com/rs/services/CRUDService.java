package com.rs.services;

import java.util.List;

/**
 * created by rs 1/31/2022.
 */
public interface CRUDService<T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);
    void delete(Integer id);

}
