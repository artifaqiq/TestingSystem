/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.m2m.TagToTest;
import com.netcracker.dev3.lomako.beans.tag.Tag;
import com.netcracker.dev3.lomako.dao.m2m.TagToTestDao;
import com.netcracker.dev3.lomako.dao.m2m.TagToTestDaoImpl;
import com.netcracker.dev3.lomako.dao.tag.TagDao;
import com.netcracker.dev3.lomako.dao.tag.TagDaoImpl;
import com.netcracker.dev3.lomako.dao.test.TestDao;
import com.netcracker.dev3.lomako.dao.test.TestDaoImpl;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;
import com.netcracker.dev3.lomako.exceptions.dao.TagToTestUniqueConflictException;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

/**
 * @author Lomako
 * @version 1.0
 */

@SuppressWarnings("Duplicates")
public class TagToTestDaoTests {
    private static final TagToTestDao tagToTestDao = TagToTestDaoImpl.getInstance();

    private static final TestDao testDao = TestDaoImpl.getInstance();

    private static final TagDao tagDao = TagDaoImpl.getInstance();

    @Test(expected = TagToTestUniqueConflictException.class)
    public void save() throws SQLException, PersistException {

        List<Tag> tags = (List<Tag>)tagDao.findAll();
        List<com.netcracker.dev3.lomako.beans.test.Test> tests =
                (List<com.netcracker.dev3.lomako.beans.test.Test>)testDao.findAll();

        final Tag tag = tags.get(Math.abs(new Random().nextInt() % tags.size()));
        final com.netcracker.dev3.lomako.beans.test.Test test =
                tests.get(Math.abs(new Random().nextInt() % tests.size()));

        TagToTest tagToTest = new TagToTest();
        tagToTest.setTestId(test.getId());
        tagToTest.setTagId(tag.getId());

        long id = tagToTestDao.save(tagToTest);

        System.out.println("Save tagToTest: " + tagToTest);
        System.out.println("id = " + id);
        
        tagToTestDao.save(tagToTest);

    }

    @Test
    public void findAll() throws SQLException {
        List<TagToTest> tagToTests = (List<TagToTest>)tagToTestDao.findAll();

        assertNotNull(tagToTests);

        for (TagToTest tagToTest : tagToTests) {
            System.out.println(tagToTest);
        }
    }

    @Test
    public void count() throws SQLException {
        List<TagToTest> tagToTests = (List<TagToTest>) tagToTestDao.findAll();
        long count = tagToTestDao.count();

        assertEquals(tagToTests.size(), count);

        System.out.println("count = " + count);
    }

    @Test
    public void delete() throws SQLException {
        List<TagToTest> tagToTests = (List<TagToTest>)tagToTestDao.findAll();
        TagToTest tagToTest = tagToTests.get(Math.abs(new Random().nextInt()) % tagToTests.size());

        tagToTestDao.delete(tagToTest);

        assertFalse(tagToTestDao.exists(tagToTest.getTagId(), tagToTest.getTestId()));

        System.out.println("Delete " + tagToTest.getTagId() + " " + tagToTest.getTestId());
    }

    @Test
    public void exists() throws SQLException {
        List<TagToTest> tagToTests = (List<TagToTest>)tagToTestDao.findAll();
        TagToTest tagToTest = tagToTests.get(Math.abs(new Random().nextInt()) % tagToTests.size());

        assertTrue(tagToTestDao.exists(tagToTest.getTagId(), tagToTest.getTestId()));
        assertFalse(tagToTestDao.exists(23859741897L, 12312435L));

    }


}
