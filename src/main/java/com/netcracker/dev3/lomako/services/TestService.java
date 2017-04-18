/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.services;

import com.netcracker.dev3.lomako.beans.Test;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public interface TestService {
    long save(Test test) throws SQLException, PersistException;
    long saveEmpty(long authorId) throws SQLException, PersistException;
    List<Test> findByUserId(long userId) throws SQLException;
    Test findById(long testId) throws SQLException;
    void delete(Test test) throws SQLException;
    void update(Test test) throws SQLException, PersistException;
    List<Test> findAll() throws SQLException;
}
