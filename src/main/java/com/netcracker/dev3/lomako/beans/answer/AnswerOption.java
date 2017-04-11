/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.beans.answer;

import java.io.Serializable;

/**
 * This class describes entity <b>AnswerOption</b>
 *
 * @author Artur Lomako
 * @version 1.0
 */
public class AnswerOption implements Serializable {

    private static final long serialVersionUID = 2520175495025108028L;

    private long id;

    private String text;

    private int order;

    private long taskId;

    /**
     * Creates new entity of the class <b>{@code AnswerOption}</b>
     */
    public AnswerOption() { }

    /**
     * Creates new entity of the class <b>{@code AnswerOption}</b>
     *
     * @param text text which describes one answer option
     */
    public AnswerOption(long id, String text, int order, long taskId) {
        this.id = id;
        this.text = text;
        this.order = order;
        this.taskId = taskId;
    }

    /**
     * @return text which describes one answer option
     * */
    public String getText() {
        return text;
    }


    /**
     * @param text text which describes one answer option
     * */
    public void setText(String text) {
        this.text = text;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    /**
     * Test two answer options to equals
     *
     * @see Object#equals(Object)
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnswerOption)) return false;

        AnswerOption that = (AnswerOption) o;

        if (id != that.id) return false;
        if (order != that.order) return false;
        if (taskId != that.taskId) return false;
        return text != null ? text.equals(that.text) : that.text == null;
    }

    /**
     * @see Object#hashCode()
     * */
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + order;
        result = 31 * result + (int) (taskId ^ (taskId >>> 32));
        return result;
    }

    /**
     * @return stringify {@code AnswerOption}
     *
     * @see Object#toString()
     * */
    @Override
    public String toString() {
        return "AnswerOption{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", order=" + order +
                ", taskId=" + taskId +
                '}';
    }
}
