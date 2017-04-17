/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils.strategy;

import com.netcracker.dev3.lomako.beans.ResultCalculationStrategyWay;

import java.security.InvalidParameterException;

/**
 * @author Lomako
 * @version 1.0
 */
public final class TestResultCalculationStrategyFactory {
    public static TestResultCalculationgStrategy create(ResultCalculationStrategyWay way) {
        switch (way) {
            case SCALED:
                return new ScaledTestResultCalculationStrategy();
            case STRICT:
                return new StrictTestResultCalculationStrategy();

            default:
                throw new InvalidParameterException();
        }
    }
}
