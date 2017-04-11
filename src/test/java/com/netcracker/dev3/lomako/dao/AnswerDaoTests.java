/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.answer.Answer;
import com.netcracker.dev3.lomako.beans.task.Task;
import com.netcracker.dev3.lomako.dao.answer.AnswerDao;
import com.netcracker.dev3.lomako.dao.answer.AnswerDaoImpl;
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
public class AnswerDaoTests {
    private static TaskDao taskDao = TaskDaoImpl.getInstance();

    private static AnswerDao answerDao = AnswerDaoImpl.getInstance();

    @Test
    public void save() throws SQLException, PersistException {
        Answer answer = new Answer();

        final Task task = ((List<Task>)taskDao.findAll()).get(0);
        final int value = Math.abs(new Random().nextInt() % 5);

        answer.setTaskId(task.getId());
        answer.setAnswer(value);

        answerDao.save(answer);
        answerDao.save(answer);

        System.out.println("Saved x2 : ");
        System.out.println(answer);
    }

    @Test
    public void update() throws SQLException, PersistException {
        List<Answer> answers = (List<Answer>)answerDao.findAll();
        Answer answer = answers.get(Math.abs(new Random().nextInt()) % answers.size());

        answer.setAnswer(answer.getAnswer() + 2);
        answerDao.update(answer);

        assertEquals(answerDao.findOne(answer.getId()).getAnswer(), answer.getAnswer());

        System.out.println("updated answer = " + answer);

    }


    @Test
    public void findAll() throws SQLException {
        List<Answer> answers = (List<Answer>)answerDao.findAll();

        assertNotNull(answers);

        for (Answer answer : answers) {
            System.out.println(answer);
        }
    }

    @Test
    public void findOne() throws SQLException {
        List<Answer> answers = (List<Answer>)answerDao.findAll();
        Answer answer = answers.get(Math.abs(new Random().nextInt()) % answers.size());

        assertEquals(answerDao.findOne(answer.getId()).toString(), answer.toString());

        System.out.println(answer);

    }

    @Test
    public void delete() throws SQLException {
        List<Answer> answers = (List<Answer>)answerDao.findAll();
        Answer answer = answers.get(Math.abs(new Random().nextInt()) % answers.size());

        answerDao.delete(answer);

        assertNull(answerDao.findOne(answer.getId()));

        System.out.println("Delete " + answer.getId());
    }

    @Test
    public void count() throws SQLException {
        long count1 = ((List<Answer>)answerDao.findAll()).size();
        long count2 = answerDao.count();

        assertEquals(count1, count2);

        System.out.println("count = " + count2);
    }

    @Test
    public void exists() throws SQLException, PersistException {
        List<Answer> answers = (List<Answer>)answerDao.findAll();
        Answer answer = answers.get(Math.abs(new Random().nextInt()) % answers.size());

        assertTrue(taskDao.exists(answer.getId()));

        System.out.println("exists: id = " + answer.getId());
    }


}
