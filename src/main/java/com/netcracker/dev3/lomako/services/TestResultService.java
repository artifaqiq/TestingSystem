/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.services;

import com.netcracker.dev3.lomako.beans.Test;
import com.netcracker.dev3.lomako.beans.TestResult;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public interface TestResultService {
    TestResult solveTest(Test original, Test solved, long userId) throws SQLException, PersistException;

    List<TestResult> findByUserId(long userId) throws SQLException;

    List<TestResult> findByTestId(long testId) throws SQLException;
}
