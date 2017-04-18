/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.services.impl;

import com.netcracker.dev3.lomako.beans.Tag;
import com.netcracker.dev3.lomako.beans.TagToTest;
import com.netcracker.dev3.lomako.beans.Test;
import com.netcracker.dev3.lomako.dao.TagDao;
import com.netcracker.dev3.lomako.dao.TagToTestDao;
import com.netcracker.dev3.lomako.dao.TestDao;
import com.netcracker.dev3.lomako.dao.impl.TagDaoImpl;
import com.netcracker.dev3.lomako.dao.impl.TagToTestDaoImpl;
import com.netcracker.dev3.lomako.dao.impl.TestDaoImpl;
import com.netcracker.dev3.lomako.services.TagService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public enum  TagServiceImpl implements TagService {

    INSTANCE;

    private static final TagDao tagDao = TagDaoImpl.getInstance();
    private static final TestDao testDao = TestDaoImpl.getInstance();
    private static final TagToTestDao tagToTestDao = TagToTestDaoImpl.getInstance();

    @Override
    public List<Test> findTestsByTagTitle(String title) throws SQLException {
        Tag tag = tagDao.findByTitle(title);
        if (tag == null) {
            return null;
        }
        List<TagToTest> tagToTests = tagToTestDao.findByTagId(tag.getId());

        List<Test> tests = new ArrayList<>();
        for(TagToTest tagToTest: tagToTests) {
            tests.add(testDao.findOne(tagToTest.getTestId()));
        }

        return tests;
    }

    @Override
    public List<Tag> findAll() throws SQLException {
        return (List<Tag>)tagDao.findAll();
    }


    public static TagService getInstance() { return INSTANCE; }
}
