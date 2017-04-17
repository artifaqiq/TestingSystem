/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils.strategy;

import com.netcracker.dev3.lomako.beans.Answer;
import com.netcracker.dev3.lomako.beans.Task;
import com.netcracker.dev3.lomako.beans.Test;

import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public class StrictTestResultCalculationStrategy implements TestResultCalculationgStrategy {
    @Override
    public int calculate(Test originalTest, Test solvedTest) {
        int points = 0;

        List<Task> originalTasks = originalTest.getTasks();
        List<Task> solvedTasks = solvedTest.getTasks();
        for (int i = 0; i < originalTasks.size(); i++) {
            List<Answer> originalAnswers = originalTasks.get(i).getAnswers();
            List<Answer> solvedAnswers = solvedTasks.get(i).getAnswers();

            boolean allCorrect = true;
            for (int j = 0; j < solvedAnswers.size(); j++) {
                if (originalAnswers.get(j).isCorrect() != solvedAnswers.get(j).isCorrect()) {
                    allCorrect = false;
                    break;
                }
            }

            if (allCorrect) {
                points += originalTasks.get(i).getPointsForCorrectAnswer();
            }
        }

        return points;
    }
}
