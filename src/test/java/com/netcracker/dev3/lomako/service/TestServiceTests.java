/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.service;

import com.netcracker.dev3.lomako.beans.Answer;
import com.netcracker.dev3.lomako.beans.Tag;
import com.netcracker.dev3.lomako.beans.Task;
import com.netcracker.dev3.lomako.beans.ResultCalculationStrategyWay;
import com.netcracker.dev3.lomako.beans.User;
import com.netcracker.dev3.lomako.dao.impl.UserDaoImpl;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;
import com.netcracker.dev3.lomako.services.TestService;
import com.netcracker.dev3.lomako.services.impl.TestServiceImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Lomako
 * @version 1.0
 */
public class TestServiceTests {

    private static final TestService testService = TestServiceImpl.getInstance();

    com.netcracker.dev3.lomako.beans.Test getTestExample()
            throws SQLException {
        com.netcracker.dev3.lomako.beans.Test test = new com.netcracker.dev3.lomako.beans.Test();
        test.setName("Test" + new Random().nextInt());

        Tag[] tags = new Tag[] {
                new Tag(0L, "Tag#" + new Random().nextInt(), null),
                new Tag(0L, "Tag#" + new Random().nextInt(), null),
        };

        Answer[] answers1 = new Answer[] {
                new Answer(0L, 0, "Answer #1 for " + test.getName(), true, 0L),
                new Answer(0L, 1, "Answer #2 for " + test.getName(), false, 0L),
                new Answer(0L, 2, "Answer #3 for " + test.getName(), true, 0L),
                new Answer(0L, 3, "Answer #4 for " + test.getName(), false, 0L),

        };

        Answer[] answers2 = new Answer[] {
                new Answer(0L, 0, "Answer #1 for " + test.getName(), false, 0L),
                new Answer(0L, 1, "Answer #2 for " + test.getName(), false, 0L),
                new Answer(0L, 2, "Answer #3 for " + test.getName(), true, 0L),
                new Answer(0L, 3, "Answer #4 for " + test.getName(), false, 0L),
                new Answer(0L, 4, "Answer #5 for " + test.getName(), false, 0L),

        };

        Task tasks[] = new Task[] {
                new Task(0L, 0L, 0, "Task #1 for " + test.getName(),
                        10, Arrays.asList(answers1)),
                new Task(0L, 0L, 1, "Task #2 for " + test.getName(),
                        10, Arrays.asList(answers2)),

        };

        User user = UserDaoImpl.getInstance().findAll().iterator().next();

        test.setTasks(Arrays.asList(tasks));
        test.setTags(Arrays.asList(tags));
        test.setAuthorId(user.getId());
        test.setResultCalculationStrategyWay(ResultCalculationStrategyWay.SCALED);
        test.setDescription("About " + test.getName());

        return test;
    }

    @Test
    public void save() throws SQLException, PersistException {
        com.netcracker.dev3.lomako.beans.Test test = getTestExample();

        long id = testService.save(test);

        System.out.println("test.getId() = " + id);
    }

    @Test
    public void saveEmpty() throws SQLException, PersistException {
        long id = testService.saveEmpty(UserDaoImpl.getInstance().findAll().iterator().next().getId());

    }

    @Test
    public void finById() throws Exception {

        com.netcracker.dev3.lomako.beans.Test test =
                testService.findById(93);
        System.out.println("test = " + test);
    }
}
