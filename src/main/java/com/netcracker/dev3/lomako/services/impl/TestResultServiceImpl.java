/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.services.impl;

import com.netcracker.dev3.lomako.beans.Test;
import com.netcracker.dev3.lomako.beans.TestResult;
import com.netcracker.dev3.lomako.dao.TestDao;
import com.netcracker.dev3.lomako.dao.TestResultDao;
import com.netcracker.dev3.lomako.dao.UserDao;
import com.netcracker.dev3.lomako.dao.impl.TestDaoImpl;
import com.netcracker.dev3.lomako.dao.impl.TestResultDaoImpl;
import com.netcracker.dev3.lomako.dao.impl.UserDaoImpl;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;
import com.netcracker.dev3.lomako.services.TestResultService;
import com.netcracker.dev3.lomako.utils.strategy.TestResultCalculationStrategyFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public enum TestResultServiceImpl implements TestResultService {

    INSTANCE;

    private static final TestResultDao testResultDao = TestResultDaoImpl.getInstance();
    private static final TestDao testDao = TestDaoImpl.getInstance();
    private static final UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public TestResult solveTest(Test original, Test solved, long userId) throws SQLException, PersistException {
        int points = TestResultCalculationStrategyFactory
                .create(original.getResultCalculationStrategyWay())
                .calculate(original, solved);

        TestResult testResult = new TestResult(
                0,
                original.getId(),
                userId,
                points,
                null,
                null
        );

        long id = testResultDao.save(testResult);
        testResult.setId(id);

        return testResult;
    }

    @Override
    public List<TestResult> findByUserId(long userId) throws SQLException {
        List<TestResult> testResults = testResultDao.findByUserId(userId);

        for (TestResult testResult : testResults) {
            testResult.setTest(testDao.findOne(testResult.getTestId()));
        }

        return testResults;
    }

    @Override
    public List<TestResult> findByTestId(long testId) throws SQLException {
        List<TestResult> testResults = testResultDao.findByTestId(testId);

        for (TestResult testResult : testResults) {
            testResult.setUser(userDao.findOne(testResult.getUserId()));
        }

        return testResults;
    }


    public static TestResultService getInstance() {
        return INSTANCE;
    }
}
