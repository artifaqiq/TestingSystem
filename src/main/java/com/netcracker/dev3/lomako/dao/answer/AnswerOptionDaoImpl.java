/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao.answer;

import com.netcracker.dev3.lomako.beans.answer.AnswerOption;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;
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
public enum  AnswerOptionDaoImpl implements AnswerOptionDao {
    INSTANCE;

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String INSERT_OPTION_SQL =
            "INSERT INTO answer_options(text, task_id, `order`) VALUES (?, ?, ?)";

    private static final String UPDATE_OPTION_SQL =
            "UPDATE answer_options SET text = ?, task_id = ?, `order` = ? WHERE id = ?";

    private static final String DELETE_OPTION_BY_ID_SQL =
            "DELETE FROM answer_options WHERE id = ?";

    private static final String SELECT_OPTION_BY_ID_SQL =
            "SELECT id, text, task_id,  `order` FROM answer_options WHERE id = ?";

    private static final String SELECT_ALL_OPTIONS_SQL =
            "SELECT id, text, task_id, `order` FROM answer_options";

    private static final String COUNT_ALL_OPTIONS_SQL =
            "SELECT COUNT(*) FROM answer_options";

    private static final String EXISTS_OPTION_BY_ID_SQL =
            "SELECT EXISTS(SELECT id FROM answer_options WHERE id = ?)";

    @Override
    public <S extends AnswerOption> void save(S entity) throws SQLException, PersistException {
        try (Connection connection = connectionPool.getConnection()) {

            PreparedStatement insertOption = connection.prepareStatement(INSERT_OPTION_SQL);

            insertOption.setString(1, entity.getText());
            insertOption.setLong(2, entity.getTaskId());
            insertOption.setInt(3, entity.getOrder());

            if (insertOption.executeUpdate() != 1) {
                PersistException e = new PersistException("On save modify not 1 entity");
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
    public <S extends AnswerOption> void update(S entity) throws SQLException, PersistException {
        try (Connection connection = connectionPool.getConnection()) {

            PreparedStatement updateOption = connection.prepareStatement(UPDATE_OPTION_SQL);
            updateOption.setString(1, entity.getText());
            updateOption.setLong(2, entity.getTaskId());
            updateOption.setInt(3, entity.getOrder());
            updateOption.setLong(4, entity.getId());

            if (updateOption.executeUpdate() != 1) {
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
    public void delete(AnswerOption entity) throws SQLException {
        long id = entity.getId();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement deleteOptionById = connection.prepareStatement(DELETE_OPTION_BY_ID_SQL);
            deleteOptionById.setLong(1, id);
            deleteOptionById.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
        }
    }

    @Override
    public AnswerOption findOne(Long primaryKey) throws SQLException {
        AnswerOption answerOption = new AnswerOption();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectOptionById = connection.prepareStatement(SELECT_OPTION_BY_ID_SQL);
            selectOptionById.setLong(1, primaryKey);

            ResultSet resultSet = selectOptionById.executeQuery();

            if(!resultSet.next()) {
                return null;
            }

            answerOption.setId(resultSet.getLong(1));
            answerOption.setText(resultSet.getString(2));
            answerOption.setTaskId(resultSet.getLong(3));
            answerOption.setOrder((resultSet.getInt(4)));

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return answerOption;
    }

    @Override
    public Iterable<AnswerOption> findAll() throws SQLException {
        List<AnswerOption> answerOptions = new ArrayList<>();

        try(Connection connection = connectionPool.getConnection()) {
            PreparedStatement selectAll = connection.prepareStatement(SELECT_ALL_OPTIONS_SQL);

            ResultSet resultSet = selectAll.executeQuery();

            while (resultSet.next()) {
                AnswerOption answerOption = new AnswerOption();

                answerOption.setId(resultSet.getLong(1));
                answerOption.setText(resultSet.getString(2));
                answerOption.setTaskId(resultSet.getLong(3));
                answerOption.setOrder(resultSet.getInt(4));

                answerOptions.add(answerOption);
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return answerOptions;
    }


    @Override
    public Long count() throws SQLException {
        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectCountAll = connection.prepareStatement(COUNT_ALL_OPTIONS_SQL);
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

            PreparedStatement existsById = connection.prepareStatement(EXISTS_OPTION_BY_ID_SQL);
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

    public static AnswerOptionDao getInstance() {
        return INSTANCE;
    }
}
