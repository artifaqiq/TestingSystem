/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao.tag;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.netcracker.dev3.lomako.beans.tag.Tag;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;
import com.netcracker.dev3.lomako.exceptions.dao.TagTitleUniqueConflictException;
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
public enum TagDaoImpl implements TagDao {

    INSTANCE;

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String INSERT_TAG_SQL =
            "INSERT INTO tags(title) VALUES (?)";

    private static final String UPDATE_TAG_SQL =
            "UPDATE tags SET title = ? WHERE id = ?";

    private static final String DELETE_TAG_BY_ID_SQL =
            "DELETE FROM tags WHERE id = ?";

    private static final String SELECT_TAG_BY_ID_SQL =
            "SELECT id, title FROM tags WHERE id = ?";

    private static final String SELECT_ALL_TAGS_SQL =
            "SELECT id, title FROM tags";

    private static final String COUNT_ALL_TAGS_SQL =
            "SELECT COUNT(*) FROM tags";

    private static final String EXISTS_TAG_BY_ID_SQL =
            "SELECT EXISTS(SELECT id FROM tags WHERE id = ?)";

    @Override
    public <S extends Tag> void save(S entity) throws SQLException, PersistException {
        try (Connection connection = connectionPool.getConnection()) {

            PreparedStatement insertTag = connection.prepareStatement(INSERT_TAG_SQL);

            insertTag.setString(1, entity.getTitle());

            try {
                if (insertTag.executeUpdate() != 1) {
                    PersistException e = new PersistException("On save modify not 1 entity");
                    Logger.getInstance().error(
                            this.getClass(), e.getMessage());
                    throw e;
                }
            } catch (MySQLIntegrityConstraintViolationException e) {
                throw new TagTitleUniqueConflictException("Tag with some title already exists");
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            throw e;
        }
    }

    @Override
    public <S extends Tag> void update(S entity) throws SQLException, PersistException {
        try (Connection connection = connectionPool.getConnection()) {

            PreparedStatement updateTag = connection.prepareStatement(UPDATE_TAG_SQL);
            updateTag.setString(1, entity.getTitle());
            updateTag.setLong(2, entity.getId());

            if (updateTag.executeUpdate() != 1) {
                PersistException e = new PersistException("On update modify not 1 entity");
                Logger.getInstance().error(
                        this.getClass(), e.getMessage());
                throw e;
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(Tag entity) throws SQLException {
        long id = entity.getId();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement deleteTagById = connection.prepareStatement(DELETE_TAG_BY_ID_SQL);
            deleteTagById.setLong(1, id);
            deleteTagById.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
        }
    }

    @Override
    public Tag findOne(Long primaryKey) throws SQLException {
        Tag tag = new Tag();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectUserById = connection.prepareStatement(SELECT_TAG_BY_ID_SQL);
            selectUserById.setLong(1, primaryKey);

            ResultSet resultSet = selectUserById.executeQuery();

            if(!resultSet.next()) {
                return null;
            }

            tag.setId(resultSet.getLong(1));
            tag.setTitle(resultSet.getString(2));

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return tag;
    }

    @Override
    public Iterable<Tag> findAll() throws SQLException {
        List<Tag> tags = new ArrayList<>();

        try(Connection connection = connectionPool.getConnection()) {
            PreparedStatement selectAll = connection.prepareStatement(SELECT_ALL_TAGS_SQL);

            ResultSet resultSet = selectAll.executeQuery();

            while (resultSet.next()) {
                Tag tag = new Tag();

                tag.setId(resultSet.getLong(1));
                tag.setTitle(resultSet.getString(2));

                tags.add(tag);
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return tags;
    }

    @Override
    public Long count() throws SQLException {
        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectCountAll = connection.prepareStatement(COUNT_ALL_TAGS_SQL);
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
    public boolean exists(Long primaryKey) throws SQLException {
        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement existsById = connection.prepareStatement(EXISTS_TAG_BY_ID_SQL);
            existsById.setLong(1, primaryKey);

            ResultSet resultSet = existsById.executeQuery();
            resultSet.next();
            return resultSet.getLong(1) == 1;

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return false;
        }
    }

    public static TagDao getInstance() {
        return INSTANCE;
    }
}
