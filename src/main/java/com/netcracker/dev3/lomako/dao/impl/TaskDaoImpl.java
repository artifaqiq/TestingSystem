/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao.impl;

import com.netcracker.dev3.lomako.beans.Task;
import com.netcracker.dev3.lomako.dao.TaskDao;
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
public enum  TaskDaoImpl implements TaskDao {

    INSTANCE;

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String INSERT_TASK_SQL =
            "INSERT INTO tasks(text, points, test_id, `order`) VALUES (?, ?, ?, ?)";

    private static final String UPDATE_TASK_SQL =
            "UPDATE tasks SET text = ?, points = ?, test_id = ?, `order` = ? WHERE id = ?";

    private static final String DELETE_TASK_BY_ID_SQL =
            "DELETE FROM tasks WHERE id = ?";

    private static final String SELECT_TASK_BY_ID_SQL =
            "SELECT id, text, points, test_id, `order` FROM tasks WHERE id = ?";

    private static final String SELECT_ALL_TASKS_SQL =
            "SELECT id, text, points, test_id, `order` FROM tasks";

    private static final String COUNT_ALL_TASKS_SQL =
            "SELECT COUNT(*) FROM tasks";

    private static final String EXISTS_TASKS_BY_ID_SQL =
            "SELECT EXISTS(SELECT id FROM tasks WHERE id = ?)";

    private static final String SELECT_LAST_INSERT_ID_SQL =
            "SELECT LAST_INSERT_ID() FROM tasks LIMIT 1";

    private static final String SELECT_TASKS_BY_TEST_ID_SQL =
            "SELECT id, text, points, test_id, `order` FROM tasks WHERE test_id = ?";

    @Override
    public synchronized <S extends Task> long save(S entity) throws SQLException, PersistException {
        try (Connection connection = connectionPool.getConnection()) {

            PreparedStatement insertTask = connection.prepareStatement(INSERT_TASK_SQL);

            insertTask.setString(1, entity.getText());
            insertTask.setInt(2, entity.getPointsForCorrectAnswer());
            insertTask.setLong(3, entity.getTestId());
            insertTask.setInt(4, entity.getOrder());

            if (insertTask.executeUpdate() != 1) {
                PersistException e = new PersistException("On save modify not 1 entity");
                Logger.getInstance().error(
                        this.getClass(), e.getMessage());
                throw e;
            }

            PreparedStatement selectId = connection.prepareStatement(SELECT_LAST_INSERT_ID_SQL);
            ResultSet resultSet = selectId.executeQuery();

            resultSet.next();
            return resultSet.getLong(1);

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            throw e;
        }
    }

    @Override
    public <S extends Task> void update(S entity) throws SQLException, PersistException {
        try (Connection connection = connectionPool.getConnection()) {

            PreparedStatement updateTest = connection.prepareStatement(UPDATE_TASK_SQL);
            updateTest.setString(1, entity.getText());
            updateTest.setInt(2, entity.getPointsForCorrectAnswer());
            updateTest.setLong(3, entity.getTestId());
            updateTest.setInt(4, entity.getOrder());
            updateTest.setLong(5, entity.getId());

            if (updateTest.executeUpdate() != 1) {
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
    public void delete(Task entity) throws SQLException {
        long id = entity.getId();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement deleteTestById = connection.prepareStatement(DELETE_TASK_BY_ID_SQL);
            deleteTestById.setLong(1, id);
            deleteTestById.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
        }
    }

    @Override
    public Task findOne(Long primaryKey) throws SQLException {

        Task task = new Task();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectUserById = connection.prepareStatement(SELECT_TASK_BY_ID_SQL);
            selectUserById.setLong(1, primaryKey);

            ResultSet resultSet = selectUserById.executeQuery();

            if(!resultSet.next()) {
                return null;
            }

            task.setId(resultSet.getLong(1));
            task.setText(resultSet.getString(2));
            task.setPointsForCorrectAnswer(resultSet.getInt(3));
            task.setTestId((resultSet.getLong(4)));
            task.setOrder(resultSet.getInt(5));

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return task;
    }

    @Override
    public Iterable<Task> findAll() throws SQLException {
        List<Task> tasks = new ArrayList<>();

        try(Connection connection = connectionPool.getConnection()) {
            PreparedStatement selectAll = connection.prepareStatement(SELECT_ALL_TASKS_SQL);

            ResultSet resultSet = selectAll.executeQuery();

            while (resultSet.next()) {
                Task task = new Task();

                task.setId(resultSet.getLong(1));
                task.setText(resultSet.getString(2));
                task.setPointsForCorrectAnswer(resultSet.getInt(3));
                task.setTestId((resultSet.getLong(4)));
                task.setOrder(resultSet.getInt(5));

                tasks.add(task);
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return tasks;
    }

    @Override
    public Long count() throws SQLException {
        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectCountAll = connection.prepareStatement(COUNT_ALL_TASKS_SQL);
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

            PreparedStatement existsById = connection.prepareStatement(EXISTS_TASKS_BY_ID_SQL);
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

    @Override
    public List<Task> findByTestId(long testId) {
        List<Task> tasks = new ArrayList<>();

        try(Connection connection = connectionPool.getConnection()) {
            PreparedStatement selectAll = connection.prepareStatement(SELECT_TASKS_BY_TEST_ID_SQL);
            selectAll.setLong(1, testId);

            ResultSet resultSet = selectAll.executeQuery();

            while (resultSet.next()) {
                Task task = new Task();

                task.setId(resultSet.getLong(1));
                task.setText(resultSet.getString(2));
                task.setPointsForCorrectAnswer(resultSet.getInt(3));
                task.setTestId((resultSet.getLong(4)));
                task.setOrder(resultSet.getInt(5));

                tasks.add(task);
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return tasks;
    }

    public static TaskDao getInstance() {
        return INSTANCE;
    }


}
