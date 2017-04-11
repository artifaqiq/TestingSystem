/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils.strategy;


import com.netcracker.dev3.lomako.beans.test.ResultCalculationStrategyWay;
import com.netcracker.dev3.lomako.utils.strategy.impl.ScaledResultCalculatingStrategy;
import com.netcracker.dev3.lomako.utils.strategy.impl.StrictResultCalculatingStrategy;

/**
 * This factory create instances of {@link ResultCalculationStrategy}
 * in dependence on {@link ResultCalculationStrategyWay}
 * */
public final class ResultCalculationStrategyCreator {
    public static ResultCalculationStrategy create(ResultCalculationStrategyWay way) {
        ResultCalculationStrategy strategy = null;

        switch (way) {
            case SCALED:
                strategy = new ScaledResultCalculatingStrategy();
                break;
            case STRICT:
                strategy = new StrictResultCalculatingStrategy();
                break;
        }

        return strategy;
    }
}
