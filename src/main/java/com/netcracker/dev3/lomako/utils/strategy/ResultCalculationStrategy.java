/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */

package com.netcracker.dev3.lomako.utils.strategy;

import com.netcracker.dev3.lomako.beans.test.Test;
import com.netcracker.dev3.lomako.beans.test.TestAnswers;

/**
 * This interface describes methods for calculate test result.
 * */
public interface ResultCalculationStrategy {
    int calculateResult(Test test, TestAnswers testAnswers);
    int calculateMaxResult(Test test);
}
