/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.services;

import com.netcracker.dev3.lomako.beans.test.Test;
import com.netcracker.dev3.lomako.dto.test.TestDto;
import com.netcracker.dev3.lomako.exceptions.dao.PersistException;

import java.sql.SQLException;

/**
 * @author Lomako
 * @version 1.0
 */
public interface TestService {
    void save(Test test) throws SQLException, PersistException;
}
