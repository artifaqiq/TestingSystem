/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.Answer;
import com.netcracker.dev3.lomako.beans.Task;
import com.netcracker.dev3.lomako.dao.impl.AnswerDaoImpl;
import com.netcracker.dev3.lomako.dao.impl.TaskDaoImpl;
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
    private static final TaskDao taskDao = TaskDaoImpl.getInstance();

    private static final AnswerDao answerDao = AnswerDaoImpl.getInstance();

    @Test
    public void save() throws SQLException, PersistException {
        Answer answer = new Answer();

        final Task task = ((List<Task>)taskDao.findAll()).get(0);

        answer.setTaskId(task.getId());
        answer.setCorrect(new Random().nextBoolean());
        answer.setText("Answer#" + new Random().nextInt());
        answer.setOrder(Math.abs(new Random().nextInt() % 10));

        long id1 = answerDao.save(answer);
        long id2 = answerDao.save(answer);

        System.out.println("Saved x2 : ");
        System.out.println(answer);

        System.out.println("id1 = " + id1);
        System.out.println("id2 = " + id2);
    }

    @Test
    public void update() throws SQLException, PersistException {
        List<Answer> answers = (List<Answer>)answerDao.findAll();
        Answer answer = answers.get(Math.abs(new Random().nextInt()) % answers.size());

        answer.setOrder(answer.getOrder() + 2);
        answerDao.update(answer);

        assertEquals(answerDao.findOne(answer.getId()).getOrder(), answer.getOrder());

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

        assertTrue(answerDao.exists(answer.getId()));

        System.out.println("exists: id = " + answer.getId());
    }


}
