package com.example.webapimoviedb.services;

import java.util.Collection;

/**
 *
 * @Author Peter Hansen, Christian Casper Hofma, Phillip Friis Petersen (Order after surname)
 */
public interface CrudService<T, ID> {
    T findById(ID id);
    Collection<T> findAll();
    T add(T entity);
    T update(T entity);
    void deleteById(ID id);
    boolean exists(ID id);
}
