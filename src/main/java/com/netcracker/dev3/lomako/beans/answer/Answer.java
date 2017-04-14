/**
 * Created by Artur Lomako on 3/18/17.
 */
package com.netcracker.dev3.lomako.beans.answer;

import java.io.Serializable;

/**
 * This class describes entity <b>Answer</b>
 *
 * @author Artur Lomako
 * @version 1.0
 */
public class Answer implements Serializable {

    private static final long serialVersionUID = 3320221651409738286L;

    private long id;

    private int order;

    private String text;

    private boolean isCorrect;

    private long taskId;

    /**
     * Creates new entity of the class <b>{@code Answer}</b>
     */
    public Answer() { }

    /**
     * Creates new entity of the class <b>{@code Answer}</b>
     *
     */
    public Answer(long id, int order, String text, boolean isCorrect, long taskId) {
        this.id = id;
        this.order = order;
        this.text = text;
        this.isCorrect = isCorrect;
        this.taskId = taskId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    /**
     * Test two answers to equals
     *
     * @see Object#equals(Object)
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;

        Answer answer = (Answer) o;

        if (id != answer.id) return false;
        if (order != answer.order) return false;
        if (isCorrect != answer.isCorrect) return false;
        if (taskId != answer.taskId) return false;
        return text.equals(answer.text);
    }

    /**
     * @see Object#hashCode()
     * */
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + order;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (isCorrect ? 1 : 0);
        result = 31 * result + (int) (taskId ^ (taskId >>> 32));
        return result;
    }

    /**
     * @return stringify {@code Answer}
     *
     * @see Object#toString()
     * */
    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", order=" + order +
                ", text=" + text +
                ", isCorrect=" + isCorrect +
                ", taskId=" + taskId +
                '}';
    }
}
