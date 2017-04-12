/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao.m2m;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.netcracker.dev3.lomako.beans.m2m.TagToTest;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;
import com.netcracker.dev3.lomako.exceptions.dao.TagToTestUniqueConflictException;
import com.netcracker.dev3.lomako.utils.ConnectionPool;
import com.netcracker.dev3.lomako.utils.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
@SuppressWarnings("Duplicates")
public enum  TagToTestDaoImpl implements TagToTestDao {

    INSTANCE;

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String INSERT_TAG_TO_TEST_SQL =
            "INSERT INTO m2m_tag_test(tag_id, test_id) VALUES (?, ?)";

    private static final String DELETE_TAG_TO_TEST_BY_ID_SQL =
            "DELETE FROM m2m_tag_test WHERE tag_id = ? AND test_id = ?";

    private static final String SELECT_ALL_TAG_TO_TEST_SQL =
            "SELECT tag_id, test_id FROM m2m_tag_test";

    private static final String COUNT_ALL_TAG_TO_TEST_SQL =
            "SELECT COUNT(*) FROM m2m_tag_test";

    private static final String EXISTS_TAG_TO_TEST_BY_ID_SQL =
            "SELECT EXISTS(SELECT tag_id FROM m2m_tag_test WHERE tag_id = ? AND test_id = ?)";

    @Override
    public <S extends TagToTest> void save(S entity) throws SQLException, PersistException {
        try (Connection connection = connectionPool.getConnection()) {

            PreparedStatement insertTagToTest = connection.prepareStatement(INSERT_TAG_TO_TEST_SQL);

            insertTagToTest.setLong(1, entity.getTagId());
            insertTagToTest.setLong(2, entity.getTestId());


            try {
                if (insertTagToTest.executeUpdate() != 1) {
                    PersistException e = new PersistException("On save modify not 1 entity");
                    Logger.getInstance().error(
                            this.getClass(), e.getMessage());
                    throw e;
                }
            } catch (MySQLIntegrityConstraintViolationException e) {
                throw new TagToTestUniqueConflictException("Tag2test with some PK already exists");
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            throw e;
        }
    }


    @Override
    public void delete(TagToTest entity) throws SQLException {
        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement deleteTagById = connection.prepareStatement(DELETE_TAG_TO_TEST_BY_ID_SQL);
            deleteTagById.setLong(1, entity.getTagId());
            deleteTagById.setLong(2, entity.getTestId());
            deleteTagById.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
        }
    }

    @Override
    public Iterable<TagToTest> findAll() throws SQLException {
        List<TagToTest> tagToTests = new ArrayList<>();

        try(Connection connection = connectionPool.getConnection()) {
            PreparedStatement selectAll = connection.prepareStatement(SELECT_ALL_TAG_TO_TEST_SQL);

            ResultSet resultSet = selectAll.executeQuery();

            while (resultSet.next()) {
                TagToTest tagToTest = new TagToTest();

                tagToTest.setTagId(resultSet.getLong(1));
                tagToTest.setTestId(resultSet.getLong(2));

                tagToTests.add(tagToTest);
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return tagToTests;
    }

    @Override
    public Long count() throws SQLException {
        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectCountAll = connection.prepareStatement(COUNT_ALL_TAG_TO_TEST_SQL);
            ResultSet resultSet = selectCountAll.executeQuery();

            resultSet.next();

            return resultSet.getLong(1);

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return 0L;
        }
    }

    @Override
    public boolean exists(long tagId, long testId) {
        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement existsById = connection.prepareStatement(EXISTS_TAG_TO_TEST_BY_ID_SQL);
            existsById.setLong(1, tagId);
            existsById.setLong(2, testId);

            ResultSet resultSet = existsById.executeQuery();
            resultSet.next();
            return resultSet.getLong(1) == 1;

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return false;
        }
    }

    @Override
    public <S extends TagToTest> void update(S entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TagToTest findOne(Void primaryKey) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean exists(Void primaryKey) throws SQLException {
        throw new UnsupportedOperationException();
    }

    public static TagToTestDao getInstance() { return INSTANCE; }
}
