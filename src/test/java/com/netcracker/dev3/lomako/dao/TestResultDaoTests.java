/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.test.TestResult;
import com.netcracker.dev3.lomako.beans.user.User;
import com.netcracker.dev3.lomako.dao.test.TestDao;
import com.netcracker.dev3.lomako.dao.test.TestDaoImpl;
import com.netcracker.dev3.lomako.dao.test.TestResultDao;
import com.netcracker.dev3.lomako.dao.test.TestResultDaoImpl;
import com.netcracker.dev3.lomako.dao.user.UserDao;
import com.netcracker.dev3.lomako.dao.user.UserDaoImpl;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author Lomako
 * @version 1.0
 */
@SuppressWarnings("Duplicates")
public class TestResultDaoTests {

    private static TestResultDao testResultDao = TestResultDaoImpl.getInstance();

    private static UserDao userDao = UserDaoImpl.getInstance();

    private static TestDao testDao = TestDaoImpl.getInstance();

    @Test
    public void save() throws SQLException, PersistException {

        final int points = new Random().nextInt() % 100;
        final User user = ((List<User>)userDao.findAll()).get(0);
        final com.netcracker.dev3.lomako.beans.test.Test test =
                ((List<com.netcracker.dev3.lomako.beans.test.Test>)testDao.findAll()).get(0);

        TestResult testResult = new TestResult();
        testResult.setPoints(points);
        testResult.setUserId(user.getId());
        testResult.setTestId(test.getId());

        testResultDao.save(testResult);
        testResultDao.save(testResult);

        System.out.println("Save testResult x2: " + testResult);

    }

    @Test
    public void update() throws SQLException, PersistException {

        List<TestResult> testResults = (List<TestResult>)testResultDao.findAll();
        TestResult testResult = testResults.get(Math.abs(new Random().nextInt()) % testResults.size());

        testResult.setPoints(testResult.getPoints() + 1);

        testResultDao.update(testResult);

        assertEquals(testResultDao.findOne(testResult.getId()).getPoints(), testResult.getPoints());

        System.out.println("updated testResult = " + testResult);

    }

    @Test
    public void findAll() throws SQLException {
        List<TestResult> testResults = (List<TestResult>)testResultDao.findAll();

        assertNotNull(testResults);

        for (TestResult testResult : testResults) {
            System.out.println(testResult);
        }
    }

    @Test
    public void findOne() throws SQLException {
        List<TestResult> testResults = (List<TestResult>) testResultDao.findAll();
        int index = Math.abs(new Random().nextInt()) % (testResults.size());

        TestResult testResult1 = testResultDao.findOne(testResults.get(index).getId());
        assertTrue(testResult1.toString().equals(testResults.get(index).toString()));

        TestResult testResult2 = testResultDao.findOne(2145245235L);
        assertNull(testResult2);

        System.out.println("Id = "+ testResults.get(index).getId());
        System.out.println(testResult1);
    }

    @Test
    public void count() throws SQLException {
        List<TestResult> testResults = (List<TestResult>) testResultDao.findAll();

        long count = testResultDao.count();
        assertEquals(testResults.size(), count);

        System.out.println("count = " + count);

    }

    @Test
    public void delete() throws SQLException {
        List<TestResult> testResults = (List<TestResult>)testResultDao.findAll();
        TestResult testResult = testResults.get(Math.abs(new Random().nextInt()) % testResults
                .size());

        testResultDao.delete(testResult);

        assertNull(testResultDao.findOne(testResult.getId()));

        System.out.println("Delete " + testResult.getId());
    }

    @Test
    public void exists() throws SQLException {
        List<TestResult> testResults = (List<TestResult>)testResultDao.findAll();
        TestResult testResult = testResults.get(Math.abs(new Random().nextInt()) % testResults
                .size());

        assertTrue(testResultDao.exists(testResult.getId()));
        assertFalse(testResultDao.exists(23859741897L));

    }

}
