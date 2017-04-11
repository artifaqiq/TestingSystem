/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao.user;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.netcracker.dev3.lomako.beans.user.Role;
import com.netcracker.dev3.lomako.beans.user.User;
import com.netcracker.dev3.lomako.exceptions.dao.EmailConflictException;
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
public enum  UserDaoImpl implements UserDao {

    INSTANCE;

    public static UserDao getInstance() {
        return INSTANCE;
    }

    private static final String INSERT_USER_SQL =
            "INSERT INTO USERS(email, encrypted_password, first_name, last_name, role_id) VALUES (?, ?, ?, ?, ?)";

    private static final String UPDATE_USER_SQL =
            "UPDATE users SET email = ?, encrypted_password = ?, first_name = ?, last_name = ?, role_id = ? WHERE id = ?";

    private static final String SELECT_ALL_USERS_SQL =
            "SELECT id, email, encrypted_password, first_name, last_name, role_id, created, updated FROM users";

    private static final String SELECT_USER_BY_ID_SQL =
            "SELECT id, email, encrypted_password, first_name, last_name, role_id, created, updated FROM users WHERE id = ?";

    private static final String COUNT_ALL_USERS_SQL =
            "SELECT COUNT(*) FROM users";

    private static final String DELETE_USER_BY_ID_SQL =
            "DELETE FROM users WHERE id = ?";

    private static final String EXISTS_USER_BY_ID_SQL =
            "SELECT EXISTS(SELECT id FROM users WHERE id = ?)";

    private static final String SELECT_USER_BY_EMAIL_SQL =
            "SELECT id, email, encrypted_password, first_name, last_name, role_id, created, updated FROM users WHERE email = ?";


    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public <S extends User> void save(S entity) throws SQLException, PersistException {

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement insertUser = connection.prepareStatement(INSERT_USER_SQL);

            insertUser.setString(1, entity.getEmail());
            insertUser.setString(2, entity.getEncryptedPassword());
            insertUser.setString(3, entity.getFirstName());
            insertUser.setString(4, entity.getLastName());
            insertUser.setInt(5, entity.getRole().getIdInRolesTable());

            try {
                if (insertUser.executeUpdate() != 1) {
                    PersistException e =  new PersistException("On save modify not 1 entity");
                    Logger.getInstance().error(
                            this.getClass(), e.getMessage());
                    throw e;
                }
            } catch (MySQLIntegrityConstraintViolationException e) {
                throw new EmailConflictException("User with some email already exists");
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            throw e;
        }
    }

    @Override
    public <S extends User> void update(S entity) throws SQLException, PersistException {
        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement updateUser = connection.prepareStatement(UPDATE_USER_SQL);
            updateUser.setString(1, entity.getEmail());
            updateUser.setString(2, entity.getEncryptedPassword());
            updateUser.setString(3, entity.getFirstName());
            updateUser.setString(4, entity.getLastName());
            updateUser.setInt(5, entity.getRole().getIdInRolesTable());
            updateUser.setLong(6, entity.getId());

            try {
                if (updateUser.executeUpdate() != 1) {
                    PersistException e = new PersistException("On update modify not 1 entity");
                    Logger.getInstance().error(
                            this.getClass(), e.getMessage());
                    throw e;
                }
            } catch (MySQLIntegrityConstraintViolationException e) {
                throw new EmailConflictException("User with some email already exists");
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            throw e;
        }
    }

    @Override
    public User findOne(Long primaryKey) throws SQLException{
        User user = new User();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectUserById = connection.prepareStatement(SELECT_USER_BY_ID_SQL);
            selectUserById.setLong(1, primaryKey);

            ResultSet resultSet = selectUserById.executeQuery();

            if(!resultSet.next()) {
                return null;
            }

            user.setId(resultSet.getLong(1));
            user.setEmail(resultSet.getString(2));
            user.setEncryptedPassword(resultSet.getString(3));
            user.setFirstName(resultSet.getString(4));
            user.setLastName(resultSet.getString(5));
            user.setRole(Role.getRoleByIdInRoleTable(resultSet.getInt(6)));
            user.setCreated((resultSet.getTimestamp(7)));
            user.setUpdated((resultSet.getTimestamp(8)));

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return user;
    }

    @Override
    public Iterable<User> findAll() throws SQLException{

        List<User> users = new ArrayList<>();

        try(Connection connection = connectionPool.getConnection()) {
            PreparedStatement selectAll = connection.prepareStatement(SELECT_ALL_USERS_SQL);

            ResultSet resultSet = selectAll.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setEmail(resultSet.getString(2));
                user.setEncryptedPassword(resultSet.getString(3));
                user.setFirstName(resultSet.getString(4));
                user.setLastName(resultSet.getString(5));
                user.setRole(Role.getRoleByIdInRoleTable(resultSet.getInt(6)));
                user.setCreated((resultSet.getTimestamp(7)));
                user.setUpdated((resultSet.getTimestamp(8)));

                users.add(user);
            }

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return users;

    }

    @Override
    public Long count() throws SQLException {

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectCountAll = connection.prepareStatement(COUNT_ALL_USERS_SQL);
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
    public void delete(User entity) throws SQLException{
        long id = entity.getId();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement deleteUserById = connection.prepareStatement(DELETE_USER_BY_ID_SQL);
            deleteUserById.setLong(1, id);
            deleteUserById.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
        }
    }

    @Override
    public boolean exists(Long primaryKey) throws SQLException{
        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement existsById = connection.prepareStatement(EXISTS_USER_BY_ID_SQL);
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
    public User findByEmail(String email) throws SQLException {
        User user = new User();

        try(Connection connection = connectionPool.getConnection()) {

            PreparedStatement selectUserById = connection.prepareStatement(SELECT_USER_BY_EMAIL_SQL);
            selectUserById.setString(1, email);

            ResultSet resultSet = selectUserById.executeQuery();

            if(!resultSet.next()) {
                return null;
            }

            user.setId(resultSet.getLong(1));
            user.setEmail(resultSet.getString(2));
            user.setEncryptedPassword(resultSet.getString(3));
            user.setFirstName(resultSet.getString(4));
            user.setLastName(resultSet.getString(5));
            user.setRole(Role.getRoleByIdInRoleTable(resultSet.getInt(6)));
            user.setCreated((resultSet.getTimestamp(7)));
            user.setUpdated((resultSet.getTimestamp(8)));

        } catch (SQLException e) {
            Logger.getInstance().error(
                    this.getClass(), e.getMessage());
            return null;
        }

        return user;
    }
}
