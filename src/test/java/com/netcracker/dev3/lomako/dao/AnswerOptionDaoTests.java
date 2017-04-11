/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.answer.AnswerOption;
import com.netcracker.dev3.lomako.beans.task.Task;
import com.netcracker.dev3.lomako.dao.answer.AnswerOptionDao;
import com.netcracker.dev3.lomako.dao.answer.AnswerOptionDaoImpl;
import com.netcracker.dev3.lomako.dao.task.TaskDao;
import com.netcracker.dev3.lomako.dao.task.TaskDaoImpl;
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
public class AnswerOptionDaoTests {
    private static TaskDao taskDao = TaskDaoImpl.getInstance();

    private static AnswerOptionDao answerOptionDao = AnswerOptionDaoImpl.getInstance();


    @Test
    public void save() throws SQLException, PersistException {
        AnswerOption answerOption = new AnswerOption();

        final Task task = ((List<Task>)taskDao.findAll()).get(0);
        final String text = "AnswerOption#" + new Random().nextInt();
        final int order = Math.abs(new Random().nextInt() % 5);

        answerOption.setTaskId(task.getId());
        answerOption.setText(text);
        answerOption.setOrder(order);

        answerOptionDao.save(answerOption);
        answerOptionDao.save(answerOption);

        System.out.println("Saved x2 : ");
        System.out.println(answerOption);
    }

    @Test
    public void update() throws SQLException, PersistException {
        List<AnswerOption> answerOptions = (List<AnswerOption>)answerOptionDao.findAll();

        AnswerOption answerOption = answerOptions.get(Math.abs(new Random().nextInt()) % answerOptions.size());

        answerOption.setText("_" + answerOption.getText());

        answerOptionDao.update(answerOption);

        assertEquals(answerOptionDao.findOne(answerOption.getId()).getText(), answerOption.getText());

        System.out.println("updated task = " + answerOption);

    }


    @Test
    public void findAll() throws SQLException {
        List<AnswerOption> answerOptions = (List<AnswerOption>)answerOptionDao.findAll();

        assertNotNull(answerOptions);

        for (AnswerOption answerOption : answerOptions) {
            System.out.println(answerOption);
        }
    }

    @Test
    public void findOne() throws SQLException {
        List<AnswerOption> answerOptions = (List<AnswerOption>)answerOptionDao.findAll();
        AnswerOption answerOption = answerOptions.get(Math.abs(new Random().nextInt() % answerOptions.size()));

        assertEquals(answerOptionDao.findOne(answerOption.getId()).toString(), answerOption.toString());

        System.out.println(answerOption);

    }

    @Test
    public void delete() throws SQLException {
        List<AnswerOption> answerOptions = (List<AnswerOption>)answerOptionDao.findAll();
        AnswerOption answerOption = answerOptions.get(Math.abs(new Random().nextInt() % answerOptions.size()));

        answerOptionDao.delete(answerOption);

        assertNull(answerOptionDao.findOne(answerOption.getId()));

        System.out.println("Delete " + answerOption.getId());
    }

    @Test
    public void count() throws SQLException {
        long count1 = ((List<AnswerOption>)answerOptionDao.findAll()).size();
        long count2 = answerOptionDao.count();

        assertEquals(count1, count2);

        System.out.println("count = " + count2);
    }

    @Test
    public void exists() throws SQLException, PersistException {
        List<AnswerOption> answerOptions = (List<AnswerOption>)answerOptionDao.findAll();
        AnswerOption answerOption = answerOptions.get(Math.abs(new Random().nextInt() % answerOptions.size()));

        assertTrue(taskDao.exists(answerOption.getId()));

        System.out.println("exists: id = " + answerOption.getId());
    }

}
