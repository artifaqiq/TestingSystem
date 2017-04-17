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
public class ScaledTestResultCalculationStrategy implements TestResultCalculationgStrategy {
    @Override
    public int calculate(Test originalTest, Test solvedTest) {
        int points = 0;

        List<Task> originalTasks = originalTest.getTasks();
        List<Task> solvedTasks = solvedTest.getTasks();
        for (int i = 0; i < originalTasks.size(); i++) {
            List<Answer> originalAnswers = originalTasks.get(i).getAnswers();
            List<Answer> solvedAnswers = solvedTasks.get(i).getAnswers();

            int originalCountCorrect = 0;
            int solvedCountCorrect = 0;

            for (int j = 0; j < originalAnswers.size(); j++) {
                if (originalAnswers.get(j).isCorrect()) {
                    originalCountCorrect++;
                }
                if (solvedAnswers.get(j).isCorrect()) {
                    solvedCountCorrect++;
                }

                if (originalAnswers.get(j).isCorrect() && solvedAnswers.get(j).isCorrect()) {
                    points += originalTasks.get(i).getPointsForCorrectAnswer();
                }
            }

            if (solvedCountCorrect > originalCountCorrect) {
                points -= originalTasks.get(i).getPointsForCorrectAnswer()
                        * (solvedCountCorrect - originalCountCorrect);
            }
        }

        return points;
    }
}
