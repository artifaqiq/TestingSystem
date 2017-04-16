/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.Task;

import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public interface TaskDao extends Dao<Task, Long> {
    List<Task> findByTestId(long testId);
}
