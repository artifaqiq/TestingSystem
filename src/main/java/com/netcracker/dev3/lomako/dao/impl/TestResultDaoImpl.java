/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao.impl;

import com.netcracker.dev3.lomako.beans.TestResult;
import com.netcracker.dev3.lomako.dao.TestResultDao;
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
public enum TestResultDaoImpl implements TestResultDao {

    INSTANCE;

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String INSERT_TEST_RESULT_SQL =
            "INSERT INTO test_results(points, user_id, test_id) VALUES (?, ?, ?)";

    private static final String UPDATE_TEST_RESULT_SQL =
            "UPDATE test_results SET points = ?, user_id = ?, test_id = ? WHERE id = ?";

    private static final String DELETE_TEST_RESULT_BY_ID_SQL =
            "DELETE FROM test_results WHERE id = ?";

    private static final String SELECT_TEST_RESULT_BY_ID_SQL =
            "SELECT id, points, user_id, test_id FROM test_results WHERE id = ?";

    private static final String SELECT_ALL_TEST_RESULTS_SQL =
            "SELECT id, points, user_id, test_id FROM test_results;";

    private static final String COUNT_ALL_TEST_RESULTS_SQL =
            "SELECT COUNT(*) FROM test_results";

    private static final String EXISTS_TEST_RESULT_BY_ID_SQL =
            "SELECT EXISTS(SELECT id FROM test_results WHERE id = ?)";

    private static final String SELECT_LAST_INSERT_ID_SQL =
            "SELECT LAST_INSERT_ID() FROM test_results LIMIT 1";

    @Override
    public synchronized <S extends TestResult> long save(S entity) throws SQLException, PersistException {
        try (Connection connection = connectionPool.getConnection()) {

            PreparedStatement insertTestResult = connection.prepareStatement(INSERT_TEST_RESULT_SQL);

            insertTestResult.setInt(1, entity.getPoints());
            insertTestResult.setLong(2, entity.getUserId());
            insertTestResult.setLong(3, entity.getTestId());

            if (insertTestResult.executeUpdate() != 1) {
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
    public <S extends TestResult> void update(S entity) throws SQLException, PersistException {
        try (Connection connection = connectionPool.getConnection()) {

            PreparedStatement updateTestResult = connection.prepareStatement(UPDATE_TEST_RESULT_SQL);
            updateTestResult.setInt(1, entity.getPoints());
            updateTestResult.setLong(2, entity.getUserId());
            updateTestResult.setLong(3, entity.getTestId());
            updateTestResult.setLong(4, entity.getId());

            if (updateTestResult.executeUpdate() != 1) {
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
    public void delete(TestResult entity) throws SQLException {
        long id = entity.getId();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement deleteTagById = connection.prepareStatement(DELETE_TEST_RESULT_BY_ID_SQL);
            deleteTagById.setLong(1, id);
            deleteTagById.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
        }
    }

    @Override
    public TestResult findOne(Long primaryKey) throws SQLException {
        TestResult testResult = new TestResult();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectUserById = connection.prepareStatement(SELECT_TEST_RESULT_BY_ID_SQL);
            selectUserById.setLong(1, primaryKey);

            ResultSet resultSet = selectUserById.executeQuery();

            if(!resultSet.next()) {
                return null;
            }

            testResult.setId(resultSet.getLong(1));
            testResult.setPoints(resultSet.getInt(2));
            testResult.setUserId(resultSet.getLong(3));
            testResult.setTestId(resultSet.getLong(4));

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return testResult;
    }

    @Override
    public Iterable<TestResult> findAll() throws SQLException {
        List<TestResult> testResults = new ArrayList<>();

        try(Connection connection = connectionPool.getConnection()) {
            PreparedStatement selectAll = connection.prepareStatement(SELECT_ALL_TEST_RESULTS_SQL);

            ResultSet resultSet = selectAll.executeQuery();

            while (resultSet.next()) {
                TestResult testResult = new TestResult();

                testResult.setId(resultSet.getLong(1));
                testResult.setPoints(resultSet.getInt(2));
                testResult.setUserId(resultSet.getLong(3));
                testResult.setTestId(resultSet.getLong(4));

                testResults.add(testResult);
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return testResults;
    }

    @Override
    public Long count() throws SQLException {
        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectCountAll = connection.prepareStatement(COUNT_ALL_TEST_RESULTS_SQL);
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

            PreparedStatement existsById = connection.prepareStatement(EXISTS_TEST_RESULT_BY_ID_SQL);
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

    public static TestResultDao getInstance() {
        return INSTANCE;
    }
}
