/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.services;

import com.netcracker.dev3.lomako.beans.Tag;
import com.netcracker.dev3.lomako.beans.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public interface TagService {
    List<Test> findTestsByTagTitle(String title) throws SQLException;
    List<Tag> findAll() throws SQLException;
}
