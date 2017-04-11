/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.beans.task;


import com.netcracker.dev3.lomako.beans.answer.Answer;
import com.netcracker.dev3.lomako.beans.answer.AnswerOption;

import java.io.Serializable;
import java.util.List;

/**
 * This class describes entity <b>Task</b>
 *
 * @author Artur Lomako
 * @version 1.0
 */
public class Task implements Serializable {

    private static final long serialVersionUID = 2286987032535820733L;

    private long id;

    private long testId;

    private int order;

    private String text;

    private int pointsForCorrectAnswer;

    private List<Answer> correctAnswers;

    private List<AnswerOption> options;


    /**
     * Creates new entity of the class <b>{@code Task}</b>
     */
    public Task() {
    }

    /**
     * Creates new entity of the class <b>{@code Category}</b>
     *
     * @param text                   text which describes task
     * @param pointsForCorrectAnswer number of points that get user for correct answer on this task
     * @param correctAnswers         correct answer to this task
     * @param options                list of options for this task
     */
    public Task(long id, long testId, int order, String text, int pointsForCorrectAnswer,
                List<Answer> correctAnswers, List<AnswerOption> options) {
        this.id = id;
        this.testId = testId;
        this.order = order;
        this.text = text;
        this.pointsForCorrectAnswer = pointsForCorrectAnswer;
        this.correctAnswers = correctAnswers;
        this.options = options;
    }

    /**
     * @return the correct answer for this task
     */
    public List<Answer> getCorrectAnswers() {
        return correctAnswers;
    }

    /**
     * @param correctAnswers correct answer for this task to set
     */
    public void setCorrectAnswers(List<Answer> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    /**
     * @return text which describes this task
     */
    public String getText() {
        return text;
    }


    /**
     * @param text text which describes this task to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return number of points that get user for correct answer on this task
     */
    public int getPointsForCorrectAnswer() {
        return pointsForCorrectAnswer;
    }

    /**
     * @param pointsForCorrectAnswer number of points that get user for correct answer on this task to set
     */
    public void setPointsForCorrectAnswer(int pointsForCorrectAnswer) {
        this.pointsForCorrectAnswer = pointsForCorrectAnswer;
    }

    /**
     * @return list of options for this task
     */
    public List<AnswerOption> getOptions() {
        return options;
    }

    /**
     * @param options list of options for this task to set
     */
    public void setOptions(List<AnswerOption> options) {
        this.options = options;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * Test two tasks to equals
     *
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (testId != task.testId) return false;
        if (order != task.order) return false;
        if (pointsForCorrectAnswer != task.pointsForCorrectAnswer) return false;
        if (text != null ? !text.equals(task.text) : task.text != null) return false;
        if (correctAnswers != null ? !correctAnswers.equals(task.correctAnswers) : task.correctAnswers != null)
            return false;
        return options != null ? options.equals(task.options) : task.options == null;
    }

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (testId ^ (testId >>> 32));
        result = 31 * result + order;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + pointsForCorrectAnswer;
        result = 31 * result + (correctAnswers != null ? correctAnswers.hashCode() : 0);
        result = 31 * result + (options != null ? options.hashCode() : 0);
        return result;
    }

    /**
     * @return stringify {@code Category}
     *
     * @see Object#toString()
     * */
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", testId=" + testId +
                ", order=" + order +
                ", text='" + text + '\'' +
                ", pointsForCorrectAnswer=" + pointsForCorrectAnswer +
                ", correctAnswers=" + correctAnswers +
                ", options=" + options +
                '}';
    }
}
