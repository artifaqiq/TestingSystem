/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.services.impl;

import com.netcracker.dev3.lomako.beans.Answer;
import com.netcracker.dev3.lomako.beans.TagToTest;
import com.netcracker.dev3.lomako.beans.Tag;
import com.netcracker.dev3.lomako.beans.Task;
import com.netcracker.dev3.lomako.beans.ResultCalculationStrategyWay;
import com.netcracker.dev3.lomako.beans.Test;
import com.netcracker.dev3.lomako.dao.AnswerDao;
import com.netcracker.dev3.lomako.dao.impl.AnswerDaoImpl;
import com.netcracker.dev3.lomako.dao.TagToTestDao;
import com.netcracker.dev3.lomako.dao.impl.TagToTestDaoImpl;
import com.netcracker.dev3.lomako.dao.TagDao;
import com.netcracker.dev3.lomako.dao.impl.TagDaoImpl;
import com.netcracker.dev3.lomako.dao.TaskDao;
import com.netcracker.dev3.lomako.dao.impl.TaskDaoImpl;
import com.netcracker.dev3.lomako.dao.TestDao;
import com.netcracker.dev3.lomako.dao.impl.TestDaoImpl;
import com.netcracker.dev3.lomako.dao.UserDao;
import com.netcracker.dev3.lomako.dao.impl.UserDaoImpl;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;
import com.netcracker.dev3.lomako.services.TestService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
@SuppressWarnings("Duplicates")
public enum TestServiceImpl implements TestService {

    INSTANCE;

    private static final AnswerDao answerDao = AnswerDaoImpl.getInstance();
    private static final TaskDao taskDao = TaskDaoImpl.getInstance();
    private static final TagToTestDao tagToTestDao = TagToTestDaoImpl.getInstance();
    private static final TagDao tagDao = TagDaoImpl.getInstance();
    private static final TestDao testDao = TestDaoImpl.getInstance();

    @Override
    public long save(Test test) throws SQLException, PersistException {
        long testId = testDao.save(test);

        for (int i = 0; i < test.getTags().size(); i++) {
            Tag tag = test.getTags().get(i);

            Tag findedTag = tagDao.findByTitle(tag.getTitle());
            if (findedTag == null) {
                tag.setId(tagDao.save(tag));
            } else {
                tag = findedTag;
            }

            long tagId = tag.getId();

            tagToTestDao.save(new TagToTest(tagId, testId));
        }

        for(int i = 0; i < test.getTasks().size(); i++) {
            Task task = test.getTasks().get(i);
            task.setOrder(i);
            task.setTestId(testId);

            long taskId = taskDao.save(task);

            for(int j = 0; j < task.getAnswers().size(); j++) {
                Answer answer = task.getAnswers().get(j);
                answer.setOrder(j);
                answer.setTaskId(taskId);

                answerDao.save(answer);
            }
        }

        return testId;
    }

    @Override
    public long saveEmpty(long authorId) throws SQLException, PersistException{
        Test test = new Test();
        test.setAuthorId(authorId);
        test.setResultCalculationStrategyWay(ResultCalculationStrategyWay.STRICT);
        test.setName("");
        test.setDescription("");

        return testDao.save(test);

    }

    @Override
    public List<Test> findByUserId(long userId) throws SQLException {
        return testDao.findByUserId(userId);
    }

    @Override
    public Test findById(long testId) throws SQLException {
        Test test = testDao.findOne(testId);
        if (test == null) {
            return null;
        }

        List<TagToTest> tagToTests = tagToTestDao.findByTestId(testId);
        List<Tag> tags = new ArrayList<>();
        for (TagToTest tagToTest: tagToTests) {
            tags.add(tagDao.findOne(tagToTest.getTagId()));
        }
        test.setTags(tags);

        test.setTasks(taskDao.findByTestId(testId));
        for (Task task: test.getTasks()) {
            task.setAnswers(answerDao.findByTaskId(task.getId()));
        }

        return test;
    }

    @Override
    public void delete(Test test) throws SQLException {
        List<TagToTest> tagToTests = tagToTestDao.findByTestId(test.getId());
        for (TagToTest tagToTest: tagToTests) {
            tagToTestDao.delete(tagToTest);
        }

        List<Task> tasks = taskDao.findByTestId(test.getId());
        for (Task task: tasks) {
            List<Answer> answers = answerDao.findByTaskId(task.getId());
            for (Answer answer: answers) {
                answerDao.delete(answer);
            }

            taskDao.delete(task);
        }

        testDao.delete(test);
    }

    @Override
    public void update(Test test) throws SQLException, PersistException {
        testDao.update(test);

        List<TagToTest> tagToTests = tagToTestDao.findByTestId(test.getId());
        for (TagToTest tagToTest: tagToTests) {
            tagToTestDao.delete(tagToTest);
        }

        List<Task> tasks = taskDao.findByTestId(test.getId());
        for (Task task: tasks) {
            List<Answer> answers = answerDao.findByTaskId(task.getId());
            for (Answer answer: answers) {
                answerDao.delete(answer);
            }

            taskDao.delete(task);
        }

        for (int i = 0; i < test.getTags().size(); i++) {
            Tag tag = test.getTags().get(i);

            Tag findedTag = tagDao.findByTitle(tag.getTitle());
            if (findedTag == null) {
                tag.setId(tagDao.save(tag));
            } else {
                tag = findedTag;
            }

            long tagId = tag.getId();

            tagToTestDao.save(new TagToTest(tagId, test.getId()));
        }

        for(int i = 0; i < test.getTasks().size(); i++) {
            Task task = test.getTasks().get(i);
            task.setOrder(i);
            task.setTestId(test.getId());

            long taskId = taskDao.save(task);

            for(int j = 0; j < task.getAnswers().size(); j++) {
                Answer answer = task.getAnswers().get(j);
                answer.setOrder(j);
                answer.setTaskId(taskId);

                answerDao.save(answer);
            }
        }


    }

    public static TestService getInstance() { return INSTANCE; }

}
