/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public interface TestDao extends Dao<Test, Long> {
    List<Test> findByUserId(long userId) throws SQLException;
}
