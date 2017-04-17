/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.services.impl;

import com.netcracker.dev3.lomako.beans.Test;
import com.netcracker.dev3.lomako.beans.TestResult;
import com.netcracker.dev3.lomako.dao.TestResultDao;
import com.netcracker.dev3.lomako.dao.impl.TestResultDaoImpl;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;
import com.netcracker.dev3.lomako.services.TestResultService;
import com.netcracker.dev3.lomako.utils.strategy.TestResultCalculationStrategyFactory;

import java.sql.SQLException;

/**
 * @author Lomako
 * @version 1.0
 */
public enum TestResultServiceImpl implements TestResultService {

    INSTANCE;

    private static final TestResultDao testResultDao = TestResultDaoImpl.getInstance();

    @Override
    public TestResult solveTest(Test original, Test solved, long userId) throws SQLException, PersistException {
        int points = TestResultCalculationStrategyFactory
                .create(original.getResultCalculationStrategyWay())
                .calculate(original, solved);

        TestResult testResult = new TestResult(
                0,
                original.getId(),
                userId,
                points
        );

        long id = testResultDao.save(testResult);
        testResult.setId(id);

        return testResult;
    }

    public static TestResultService getInstance() {
        return INSTANCE;
    }
}
