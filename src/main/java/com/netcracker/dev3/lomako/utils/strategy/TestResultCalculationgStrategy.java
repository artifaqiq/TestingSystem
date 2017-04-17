/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils.strategy;

import com.netcracker.dev3.lomako.beans.Test;

/**
 * @author Lomako
 * @version 1.0
 */
public interface TestResultCalculationgStrategy {
    int calculate(Test originalTest, Test solvedTest);
}
