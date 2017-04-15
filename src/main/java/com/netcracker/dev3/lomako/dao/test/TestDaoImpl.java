/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao.test;

import com.netcracker.dev3.lomako.beans.test.ResultCalculationStrategyWay;
import com.netcracker.dev3.lomako.beans.test.Test;
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
public enum  TestDaoImpl implements TestDao {

    INSTANCE;

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String INSERT_TEST_SQL =
            "INSERT INTO tests(name, description, strategy_id, user_id) VALUES (?, ?, ?, ?)";

    private static final String UPDATE_TEST_SQL =
            "UPDATE tests SET name = ?, description = ?, strategy_id = ?, user_id = ? WHERE id = ?";

    private static final String DELETE_TEST_BY_ID_SQL =
            "DELETE FROM tests WHERE id = ?";

    private static final String SELECT_TEST_BY_ID_SQL =
            "SELECT id, name, description, user_id, strategy_id, created, updated FROM tests WHERE id = ?";

    private static final String SELECT_ALL_TESTS_SQL =
            "SELECT id, name, description, user_id, strategy_id, created, updated FROM tests";

    private static final String COUNT_ALL_TESTS_SQL =
            "SELECT COUNT(*) FROM tests";

    private static final String EXISTS_TEST_BY_ID_SQL =
            "SELECT EXISTS(SELECT id FROM tests WHERE id = ?)";

    private static final String SELECT_LAST_INSERT_ID_SQL =
            "SELECT LAST_INSERT_ID() FROM tests LIMIT 1;";

    @Override
    public synchronized <S extends Test> long save(S entity) throws SQLException, PersistException {
        try (Connection connection = connectionPool.getConnection()) {

            PreparedStatement insertTest = connection.prepareStatement(INSERT_TEST_SQL);

            insertTest.setString(1, entity.getName());
            insertTest.setString(2, entity.getDescription());
            insertTest.setLong(3, entity.getResultCalculationStrategyWay().getIdInRolesTable());
            insertTest.setLong(4, entity.getAuthorId());

            if (insertTest.executeUpdate() != 1) {
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
    public <S extends Test> void update(S entity) throws SQLException, PersistException {
        try (Connection connection = connectionPool.getConnection()) {

            PreparedStatement updateTest = connection.prepareStatement(UPDATE_TEST_SQL);
            updateTest.setString(1, entity.getName());
            updateTest.setString(2, entity.getDescription());
            updateTest.setLong(3, entity.getResultCalculationStrategyWay().getIdInRolesTable());
            updateTest.setLong(4, entity.getAuthorId());
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
    public void delete(Test entity) throws SQLException {
        long id = entity.getId();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement deleteTestById = connection.prepareStatement(DELETE_TEST_BY_ID_SQL);
            deleteTestById.setLong(1, id);
            deleteTestById.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
        }
    }

    @Override
    public Test findOne(Long primaryKey) throws SQLException {
        Test test = new Test();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectUserById = connection.prepareStatement(SELECT_TEST_BY_ID_SQL);
            selectUserById.setLong(1, primaryKey);

            ResultSet resultSet = selectUserById.executeQuery();

            if(!resultSet.next()) {
                return null;
            }

            test.setId(resultSet.getLong(1));
            test.setName(resultSet.getString(2));
            test.setDescription(resultSet.getString(3));
            test.setAuthorId(resultSet.getLong(4));
            test.setResultCalculationStrategyWay(
                    ResultCalculationStrategyWay.getStrategyByIdInRoleTable(resultSet.getInt(5)));
            test.setCreated(resultSet.getTimestamp(6));
            test.setUpdated(resultSet.getTimestamp(7));

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return test;
    }

    @Override
    public Iterable<Test> findAll() throws SQLException {
        List<Test> tests = new ArrayList<>();

        try(Connection connection = connectionPool.getConnection()) {
            PreparedStatement selectAll = connection.prepareStatement(SELECT_ALL_TESTS_SQL);

            ResultSet resultSet = selectAll.executeQuery();

            while (resultSet.next()) {
                Test test = new Test();

                test.setId(resultSet.getLong(1));
                test.setName(resultSet.getString(2));
                test.setDescription(resultSet.getString(3));
                test.setAuthorId(resultSet.getLong(4));
                test.setResultCalculationStrategyWay(
                        ResultCalculationStrategyWay.getStrategyByIdInRoleTable(resultSet.getInt(5)));
                test.setCreated(resultSet.getTimestamp(6));
                test.setUpdated(resultSet.getTimestamp(7));

                tests.add(test);
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return tests;
    }

    @Override
    public Long count() throws SQLException {
        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectCountAll = connection.prepareStatement(COUNT_ALL_TESTS_SQL);
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

            PreparedStatement existsById = connection.prepareStatement(EXISTS_TEST_BY_ID_SQL);
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

    public static TestDao getInstance() {
        return INSTANCE;
    }
}
