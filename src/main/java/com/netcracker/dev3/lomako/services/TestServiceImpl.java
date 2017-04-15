/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.services;

import com.netcracker.dev3.lomako.beans.test.Test;
import com.netcracker.dev3.lomako.dao.answer.AnswerDao;
import com.netcracker.dev3.lomako.dao.answer.AnswerDaoImpl;
import com.netcracker.dev3.lomako.dao.m2m.TagToTestDao;
import com.netcracker.dev3.lomako.dao.m2m.TagToTestDaoImpl;
import com.netcracker.dev3.lomako.dao.tag.TagDao;
import com.netcracker.dev3.lomako.dao.tag.TagDaoImpl;
import com.netcracker.dev3.lomako.dao.task.TaskDao;
import com.netcracker.dev3.lomako.dao.task.TaskDaoImpl;
import com.netcracker.dev3.lomako.dao.test.TestDao;
import com.netcracker.dev3.lomako.dao.test.TestDaoImpl;
import com.netcracker.dev3.lomako.dao.user.UserDao;
import com.netcracker.dev3.lomako.dao.user.UserDaoImpl;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;

import java.sql.SQLException;

/**
 * @author Lomako
 * @version 1.0
 */
public final class TestServiceImpl implements TestService {

    private static final UserDao userDao = UserDaoImpl.getInstance();
    private static final AnswerDao answerDao = AnswerDaoImpl.getInstance();
    private static final TaskDao taskDao = TaskDaoImpl.getInstance();
    private static final TagToTestDao tagToTestDao = TagToTestDaoImpl.getInstance();
    private static final TagDao tagDao = TagDaoImpl.getInstance();
    private static final TestDao testDao = TestDaoImpl.getInstance();

    @Override
    public void save(Test test) throws SQLException, PersistException {


    }
}
