/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.exceptions.dao.PersistException;

import java.sql.SQLException;

public interface Dao<T, ID> {
    <S extends T> void save(S entity) throws SQLException, PersistException;

    <S extends T> void update(S entity) throws SQLException, PersistException;

    void delete(T entity) throws SQLException;

    T findOne(ID primaryKey) throws SQLException;

    Iterable<T> findAll() throws SQLException;

    Long count() throws SQLException;

    boolean exists(ID primaryKey) throws SQLException;


}
