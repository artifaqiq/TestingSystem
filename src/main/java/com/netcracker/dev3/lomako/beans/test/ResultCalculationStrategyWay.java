package com.netcracker.dev3.lomako.beans.test;

/**
 * Show available kind of calculate test result
 *
 * <li>{@link #STRICT}</li>
 * <li>{@link #SCALED}</li>
 *
 * @author Artur Lomako
 * @version 1.0
 * */
public enum ResultCalculationStrategyWay {

    /**
     * In this instance in a task
     * that has multiple answers,
     * the correct answers should be all
     * */
    STRICT,

    /**
     * In this instance in a task
     * that has multiple answers,
     * points are awarded for each correct answer
     * */
    SCALED;

    public int getIdInRolesTable() {
        switch (this) {
            case STRICT:
                return 1;
            case SCALED:
                return 2;

            default:
                return 0;
        }

    }

    public static ResultCalculationStrategyWay getStrategyByIdInRoleTable(int id) {
        switch (id) {
            case 1:
                return ResultCalculationStrategyWay.STRICT;
            case 2:
                return ResultCalculationStrategyWay.SCALED;

            default:
                return null;
        }
    }
}
