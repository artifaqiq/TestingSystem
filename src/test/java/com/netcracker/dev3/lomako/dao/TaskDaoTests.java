/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.task.Task;
import com.netcracker.dev3.lomako.dao.task.TaskDao;
import com.netcracker.dev3.lomako.dao.task.TaskDaoImpl;
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
public class TaskDaoTests {
    private static final TestDao testDao = TestDaoImpl.getInstance();

    private static final UserDao userDao = UserDaoImpl.getInstance();

    private static final TaskDao taskDao = TaskDaoImpl.getInstance();

    @Test
    public void save() throws SQLException, PersistException {
        Task task = new Task();

        final com.netcracker.dev3.lomako.beans.test.Test test =
                ((List<com.netcracker.dev3.lomako.beans.test.Test>)testDao.findAll())
                        .get(0);
        final String text = "Task#" + new Random().nextInt();
        final int points = Math.abs(new Random().nextInt() % 5);
        final int order = Math.abs(new Random().nextInt() % 5);

        task.setText(text);
        task.setPointsForCorrectAnswer(points);
        task.setOrder(order);
        task.setTestId(test.getId());

        long id1= taskDao.save(task);
        long id2 = taskDao.save(task);

        System.out.println("Saved x2 : ");
        System.out.println(task);

        System.out.println("id1 = " + id1);
        System.out.println("id2 = " + id2);
    }

    @Test
    public void update() throws SQLException, PersistException {
        List<Task> tasks = (List<Task>)taskDao.findAll();

        Task task = tasks.get(Math.abs(new Random().nextInt()) % tasks.size());

        task.setText("_" + task.getText());

        taskDao.update(task);

        assertEquals(taskDao.findOne(task.getId()).getText(), task.getText());

        System.out.println("updated task = " + task);

    }


    @Test
    public void findAll() throws SQLException {
        List<Task> tasks = (List<Task>)taskDao.findAll();

        assertNotNull(tasks);

        for (Task task : tasks) {
            System.out.println(tasks);
        }

    }

    @Test
    public void findOne() throws SQLException {
        List<Task> tasks = (List<Task>)taskDao.findAll();
        Task task = tasks.get(Math.abs(new Random().nextInt() % tasks.size()));

        assertEquals(taskDao.findOne(task.getId()).toString(), task.toString());

        System.out.println(task);

    }

    @Test
    public void delete() throws SQLException {
        List<Task> tasks = (List<Task>)taskDao.findAll();
        Task task = tasks.get(Math.abs(new Random().nextInt() % tasks.size()));

        taskDao.delete(task);

        assertNull(taskDao.findOne(task.getId()));

        System.out.println("Delete " + task.getId());
    }

    @Test
    public void count() throws SQLException {
        long count1 = ((List<Task>)taskDao.findAll()).size();
        long count2 = taskDao.count();

        assertEquals(count1, count2);

        System.out.println("count = " + count2);
    }

    @Test
    public void exists() throws SQLException, PersistException {
        List<Task> tasks = (List<Task>)taskDao.findAll();
        Task task = tasks.get(Math.abs(new Random().nextInt() % tasks.size()));

        assertTrue(taskDao.exists(task.getId()));

        System.out.println("exists: id = " + task.getId());
    }
}
