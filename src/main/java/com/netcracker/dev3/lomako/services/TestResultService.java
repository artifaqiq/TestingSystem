/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.services;

import com.netcracker.dev3.lomako.beans.Test;
import com.netcracker.dev3.lomako.beans.TestResult;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;

import java.sql.SQLException;

/**
 * @author Lomako
 * @version 1.0
 */
public interface TestResultService {
    TestResult solveTest(Test original, Test solved, long userId) throws SQLException, PersistException;
}
