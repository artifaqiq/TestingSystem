/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.beans.task;


import com.netcracker.dev3.lomako.beans.answer.Answer;

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

    private List<Answer> answers;

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
     * @param answers         correct answer to this task
     */
    public Task(long id, long testId, int order, String text, int pointsForCorrectAnswer, List<Answer> answers) {
        this.id = id;
        this.testId = testId;
        this.order = order;
        this.text = text;
        this.pointsForCorrectAnswer = pointsForCorrectAnswer;
        this.answers = answers;
    }

    /**
     * @return the correct answer for this task
     */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * @param answers correct answer for this task to set
     */
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
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
        return answers != null ? answers.equals(task.answers) : task.answers == null;
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
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
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
                ", answers=" + answers +
                '}';
    }
}
