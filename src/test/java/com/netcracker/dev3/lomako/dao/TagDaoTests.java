/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.tag.Tag;
import com.netcracker.dev3.lomako.dao.tag.TagDao;
import com.netcracker.dev3.lomako.dao.tag.TagDaoImpl;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;
import com.netcracker.dev3.lomako.exceptions.dao.TagTitleUniqueConflictException;
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
public class TagDaoTests {
    private static TagDao tagDao = TagDaoImpl.getInstance();

    @Test(expected = TagTitleUniqueConflictException.class)
    public void save() throws SQLException, PersistException {

        final String title = "Tag#" + new Random().nextInt();

        Tag testTag = new Tag();
        testTag.setTitle(title);

        tagDao.save(testTag);
        tagDao.save(testTag);

        System.out.println("Save tag: " + testTag);

    }

    @Test
    public void update() throws SQLException, PersistException {

        List<Tag> tags = (List<Tag>)tagDao.findAll();
        Tag tag = tags.get(Math.abs(new Random().nextInt()) % tags.size());

        tag.setTitle("_" + tag.getTitle());

        tagDao.update(tag);

        assertEquals(tagDao.findOne(tag.getId()).getTitle(), tag.getTitle());

        System.out.println("updated tag = " + tag);

    }

    @Test
    public void findAll() throws SQLException {
        List<Tag> tags = (List<Tag>)tagDao.findAll();

        assertNotNull(tags);

        for (Tag tag : tags) {
            System.out.println(tag);
        }
    }

    @Test
    public void findOne() throws SQLException {
        List<Tag> tags = (List<Tag>) tagDao.findAll();
        int index = Math.abs(new Random().nextInt()) % (tags.size());

        Tag tag1 = tagDao.findOne(tags.get(index).getId());

        assertTrue(tag1.toString().equals(tags.get(index).toString()));

        Tag tag2 = tagDao.findOne(2145245235L);
        assertNull(tag2);

        System.out.println("Id = "+ tags.get(index).getId());
        System.out.println(tag1);
    }

    @Test
    public void count() throws SQLException {
        List<Tag> tags = (List<Tag>) tagDao.findAll();
        long count = tagDao.count();
        assertEquals(tags.size(), count);

        System.out.println("count = " + count);

    }

    @Test
    public void delete() throws SQLException {
        List<Tag> tags = (List<Tag>)tagDao.findAll();
        Tag tag = tags.get(Math.abs(new Random().nextInt()) % tags.size());

        tagDao.delete(tag);

        assertNull(tagDao.findOne(tag.getId()));

        System.out.println("Delete " + tag.getId());
    }

    @Test
    public void exists() throws SQLException {
        List<Tag> tags = (List<Tag>)tagDao.findAll();
        Tag tag = tags.get(Math.abs(new Random().nextInt()) % tags.size());

        assertTrue(tagDao.exists(tag.getId()));
        assertFalse(tagDao.exists(23859741897L));

    }

}
