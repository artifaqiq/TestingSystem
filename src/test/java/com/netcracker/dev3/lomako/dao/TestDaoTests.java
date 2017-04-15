/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.test.ResultCalculationStrategyWay;
import com.netcracker.dev3.lomako.beans.user.User;
import com.netcracker.dev3.lomako.dao.test.TestDao;
import com.netcracker.dev3.lomako.dao.test.TestDaoImpl;
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
public class TestDaoTests {

    private static final TestDao testDao = TestDaoImpl.getInstance();

    private static final UserDao userDao = UserDaoImpl.getInstance();

    @Test
    public void save() throws SQLException, PersistException {
        com.netcracker.dev3.lomako.beans.test.Test test = new com.netcracker.dev3.lomako.beans.test.Test();

        final User author = ((List<User>)userDao.findAll()).get(0);
        final ResultCalculationStrategyWay strategy = ResultCalculationStrategyWay.SCALED;
        final String name = "Test#" + new Random().nextInt();
        final String description = "About " + name;

        test.setName(name);
        test.setDescription(description);
        test.setAuthorId(author.getId());
        test.setResultCalculationStrategyWay(strategy);

        long id1 = testDao.save(test);
        long id2 = testDao.save(test);

        System.out.println("Saved x2 : ");
        System.out.println(test);

        System.out.println("id1 = " + id1);
        System.out.println("id2 = " + id2);
    }

    @Test
    public void update() throws SQLException, PersistException {
        List<com.netcracker.dev3.lomako.beans.test.Test> tests =
                (List<com.netcracker.dev3.lomako.beans.test.Test>)testDao.findAll();

        com.netcracker.dev3.lomako.beans.test.Test test =
                tests.get(Math.abs(new Random().nextInt()) % tests.size());

        test.setName("_" + test.getName());

        testDao.update(test);

        assertEquals(testDao.findOne(test.getId()).getName(), test.getName());

        System.out.println("updated test = " + test);

    }


    @Test
    public void findAll() throws SQLException {
        List<com.netcracker.dev3.lomako.beans.test.Test> tests =
                (List<com.netcracker.dev3.lomako.beans.test.Test>)testDao.findAll();

        assertNotNull(tests);

        for (com.netcracker.dev3.lomako.beans.test.Test test : tests) {
            System.out.println(test);
        }

    }

    @Test
    public void findOne() throws SQLException {
        List<com.netcracker.dev3.lomako.beans.test.Test> tests =
                (List<com.netcracker.dev3.lomako.beans.test.Test>)testDao.findAll();

        com.netcracker.dev3.lomako.beans.test.Test test = tests.get(
                Math.abs(new Random().nextInt() % tests.size()));

        assertEquals(testDao.findOne(test.getId()).toString(), test.toString());

        System.out.println(test);

    }

    @Test
    public void delete() throws SQLException {
        List<com.netcracker.dev3.lomako.beans.test.Test> tests =
                (List<com.netcracker.dev3.lomako.beans.test.Test>)testDao.findAll();

        com.netcracker.dev3.lomako.beans.test.Test test = tests.get(
                Math.abs(new Random().nextInt() % tests.size()));

        testDao.delete(test);

        assertNull(testDao.findOne(test.getId()));
    }

    @Test
    public void count() throws SQLException {
        long count1 = ((List<com.netcracker.dev3.lomako.beans.test.Test>)testDao.findAll()).size();
        long count2 = testDao.count();

        assertEquals(count1, count2);

        System.out.println("count = " + count2);
    }

    @Test
    public void exists() throws SQLException, PersistException {

        List<com.netcracker.dev3.lomako.beans.test.Test> tests =
                (List<com.netcracker.dev3.lomako.beans.test.Test>)testDao.findAll();

        com.netcracker.dev3.lomako.beans.test.Test test =
                tests.get(Math.abs(new Random().nextInt()) % tests.size());

        assertTrue(testDao.exists(test.getId()));

        System.out.println("exists: id = " + test.getId());
    }

}
