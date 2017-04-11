/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils.strategy.impl;


import com.netcracker.dev3.lomako.beans.answer.Answer;
import com.netcracker.dev3.lomako.beans.task.Task;
import com.netcracker.dev3.lomako.beans.test.Test;
import com.netcracker.dev3.lomako.beans.test.TestAnswers;
import com.netcracker.dev3.lomako.utils.strategy.ResultCalculationStrategy;

import java.util.ListIterator;

/**
 * Implementation {@code ResultCalculationStrategy}
 * This strategy match {@link com.netcracker.dev3.lomako.beans.test.ResultCalculationStrategyWay#SCALED}
 *
 * @see ResultCalculationStrategy
 * @see com.netcracker.dev3.lomako.beans.test.ResultCalculationStrategyWay#SCALED
 * */
public final class ScaledResultCalculatingStrategy implements ResultCalculationStrategy {

    @Override
    public int calculateResult(Test test, TestAnswers testAnswers) {
        ListIterator<Task> taskIterator = test.getTasks().listIterator();
        ListIterator<Answer> answerIterator = testAnswers.getAnswers().listIterator();

        int result = 0;

        while (taskIterator.hasNext() && answerIterator.hasNext()) {
            Task task = taskIterator.next();
            Answer correctAnswer = task.getCorrectAnswer();
            Answer userAnswer = answerIterator.next();

            for(int i : correctAnswer.getAnswers()) {
                if(userAnswer.getAnswers().contains(i)) {
                    result += task.getPointsForCorrectAnswer();
                }
            }
        }

        return result;
    }

    @Override
    public int calculateMaxResult(Test test) {
        ListIterator<Task> taskIterator = test.getTasks().listIterator();

        int result = 0;

        while (taskIterator.hasNext()) {
            Task task = taskIterator.next();
            Answer answer = task.getCorrectAnswer();

            result += task.getPointsForCorrectAnswer() * answer.getAnswers().size();
        }

        return result;
    }
}