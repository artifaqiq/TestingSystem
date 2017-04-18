/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.services.impl;

import com.netcracker.dev3.lomako.beans.Role;
import com.netcracker.dev3.lomako.beans.User;
import com.netcracker.dev3.lomako.dao.UserDao;
import com.netcracker.dev3.lomako.dao.impl.UserDaoImpl;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;
import com.netcracker.dev3.lomako.exceptions.dao.UserEmailUniqueConflictException;
import com.netcracker.dev3.lomako.exceptions.service.UserNotFoundException;
import com.netcracker.dev3.lomako.services.UserService;
import com.netcracker.dev3.lomako.utils.PasswordCryptography;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public enum  UserServiceImpl implements UserService {
    INSTANCE;

    private static final UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public User login(String email, String password) throws SQLException, UserNotFoundException{
        User user = userDao.findByEmail(email);
        if (user == null || !PasswordCryptography.check(password, user.getEncryptedPassword())) {
            throw new UserNotFoundException();
        } else {
            return user;
        }
    }

    @Override
    public User register(String email, String password, String firstName, String lastName)
            throws SQLException, UserEmailUniqueConflictException {
        User user = new User(
                0,
                email,
                PasswordCryptography.crypt(password),
                firstName,
                lastName,
                Role.USER,
                null,
                null
        );

        try {
            long id = userDao.save(user);
            user = userDao.findByEmail(email);
            user.setId(id);

        } catch (PersistException e) {
            throw new UserEmailUniqueConflictException();
        }

        return user;

    }

    @Override
    public List<User> findAll() throws SQLException {
        return (List<User>)userDao.findAll();
    }


    public static UserService getInstance() { return INSTANCE; }
}
