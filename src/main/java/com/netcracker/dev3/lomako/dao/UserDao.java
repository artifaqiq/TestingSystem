/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.User;

import java.sql.SQLException;

public interface UserDao extends Dao<User, Long> {
    User findByEmail(String email) throws SQLException;
}
