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

    private int answer;

    private long taskId;

    /**
     * Creates new entity of the class <b>{@code Answer}</b>
     */
    public Answer() { }

    /**
     * Creates new entity of the class <b>{@code Answer}</b>
     *
     * @param answer list of numbers of answer. Every number correspond with one answer option
     */
    public Answer(long id, int answer, long taskId) {
        this.id = id;
        this.answer = answer;
        this.taskId = taskId;
    }

    /**
     * @return answer value
     * */
    public int getAnswer() {
        return answer;
    }

    /**
     * @param answer answer value
     * */
    public void setAnswer(int answer) {
        this.answer = answer;
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

        Answer answer1 = (Answer) o;

        if (id != answer1.id) return false;
        if (answer != answer1.answer) return false;
        return taskId == answer1.taskId;
    }

    /**
     * @see Object#hashCode()
     * */
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + answer;
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
                ", answer=" + answer +
                ", taskId=" + taskId +
                '}';
    }
}
