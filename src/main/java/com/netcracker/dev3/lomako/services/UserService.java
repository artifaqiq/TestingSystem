/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.services;

import com.netcracker.dev3.lomako.beans.User;
import com.netcracker.dev3.lomako.exceptions.dao.UserEmailUniqueConflictException;
import com.netcracker.dev3.lomako.exceptions.service.UserNotFoundException;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public interface UserService {
    User login(String email, String password) throws SQLException, UserNotFoundException;

    User register(String email, String password, String firstName, String lastName)
            throws SQLException, UserEmailUniqueConflictException;

    List<User> findAll() throws SQLException;
}
