/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao.answer;

import com.netcracker.dev3.lomako.beans.answer.Answer;
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
public enum  AnswerDaoImpl implements AnswerDao {
    INSTANCE;

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String INSERT_ANSWER_SQL =
            "INSERT INTO correct_answers(answer, task_id) VALUES (?, ?)";

    private static final String UPDATE_ANSWER_SQL =
            "UPDATE correct_answers SET answer = ?, task_id = ? WHERE id = ?";

    private static final String DELETE_ANSWER_BY_ID_SQL =
            "DELETE FROM correct_answers WHERE id = ?";

    private static final String SELECT_ANSWER_BY_ID_SQL =
            "SELECT id, answer, task_id FROM correct_answers WHERE id = ?";

    private static final String SELECT_ALL_ANSWERS_SQL =
            "SELECT id, answer, task_id FROM correct_answers";

    private static final String COUNT_ALL_ANSWERS_SQL =
            "SELECT COUNT(*) FROM correct_answers";

    private static final String EXISTS_ANSWER_BY_ID_SQL =
            "SELECT EXISTS(SELECT id FROM correct_answers WHERE id = ?);";

    @Override
    public <S extends Answer> void save(S entity) throws SQLException, PersistException {
        try (Connection connection = connectionPool.getConnection()) {

            PreparedStatement insertAnswer = connection.prepareStatement(INSERT_ANSWER_SQL);

            insertAnswer.setInt(1, entity.getAnswer());
            insertAnswer.setLong(2, entity.getTaskId());

            if (insertAnswer.executeUpdate() != 1) {
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
    public <S extends Answer> void update(S entity) throws SQLException, PersistException {
        try (Connection connection = connectionPool.getConnection()) {

            PreparedStatement updateAnswer = connection.prepareStatement(UPDATE_ANSWER_SQL);
            updateAnswer.setInt(1, entity.getAnswer());
            updateAnswer.setLong(2, entity.getTaskId());
            updateAnswer.setLong(3, entity.getId());

            if (updateAnswer.executeUpdate() != 1) {
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
    public void delete(Answer entity) throws SQLException {
        long id = entity.getId();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement deleteAnswerById = connection.prepareStatement(DELETE_ANSWER_BY_ID_SQL);
            deleteAnswerById.setLong(1, id);
            deleteAnswerById.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
        }
    }

    @Override
    public Answer findOne(Long primaryKey) throws SQLException {
        Answer answer = new Answer();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectAnswerById = connection.prepareStatement(SELECT_ANSWER_BY_ID_SQL);
            selectAnswerById.setLong(1, primaryKey);

            ResultSet resultSet = selectAnswerById.executeQuery();

            if(!resultSet.next()) {
                return null;
            }

            answer.setId(resultSet.getLong(1));
            answer.setAnswer(resultSet.getInt(2));
            answer.setTaskId(resultSet.getLong(3));

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return answer;
    }

    @Override
    public Iterable<Answer> findAll() throws SQLException {
        List<Answer> answers = new ArrayList<>();

        try(Connection connection = connectionPool.getConnection()) {
            PreparedStatement selectAll = connection.prepareStatement(SELECT_ALL_ANSWERS_SQL);

            ResultSet resultSet = selectAll.executeQuery();

            while (resultSet.next()) {
                Answer answer = new Answer();

                answer.setId(resultSet.getLong(1));
                answer.setAnswer(resultSet.getInt(2));
                answer.setTaskId(resultSet.getLong(3));

                answers.add(answer);
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return answers;
    }

    @Override
    public Long count() throws SQLException {
        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectCountAll = connection.prepareStatement(COUNT_ALL_ANSWERS_SQL);
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

            PreparedStatement existsById = connection.prepareStatement(EXISTS_ANSWER_BY_ID_SQL);
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

    public static AnswerDao getInstance() {
        return INSTANCE;
    }
}
