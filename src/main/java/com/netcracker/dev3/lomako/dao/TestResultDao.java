/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.TestResult;

import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public interface TestResultDao extends Dao<TestResult, Long> {
    List<TestResult> findByUserId(long userId);

    List<TestResult> findByTestId(long testId);
}
