/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.beans.test;


import com.netcracker.dev3.lomako.beans.task.Task;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * This class describes entity <b>Test</b>
 *
 * @see Test
 *
 * @author lomako
 * @version 1.0
 */
public class Test implements Serializable {

    private static final long serialVersionUID = -5965469173441798469L;

    private long id;

    private long authorId;

    private String name;

    private String description;

    private List<Task> tasks;

    private ResultCalculationStrategyWay resultCalculationStrategyWay;

    private Date created;

    private Date updated;

    /**
     * Creates new entity of the class <b>{@code Test}</b>
     */
    public Test() {
    }

    /**
     * Creates new entity of the class <b>{@code Test}</b>
     *
     * @param name name of test
     * @param description descriptions of test
     * @param tasks list of tasks that are in this test
     * @param resultCalculationStrategyWay way to calculate test result
     *                                     @see ResultCalculationStrategyWay
     * @param authorId PK of author in users table
     *
     */
    public Test(long id, long authorId, String name, String description, List<Task> tasks,
                ResultCalculationStrategyWay resultCalculationStrategyWay, Date created, Date updated) {
        this.id = id;
        this.authorId = authorId;
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.resultCalculationStrategyWay = resultCalculationStrategyWay;
        this.created = created;
        this.updated = updated;
    }

    /**
     * @return way to calculate test result
     *
     * @see ResultCalculationStrategyWay
     * */
    public ResultCalculationStrategyWay getResultCalculationStrategyWay() {
        return resultCalculationStrategyWay;
    }

    /**
     * @param resultCalculationStrategyWay way to calculate test result
     *
     * @see ResultCalculationStrategyWay
     * */
    public void setResultCalculationStrategyWay(ResultCalculationStrategyWay resultCalculationStrategyWay) {
        this.resultCalculationStrategyWay = resultCalculationStrategyWay;
    }

    /**
     * @return list of tasks
     * */
    public List<Task> getTasks() {
        return tasks;
    }


    /**
     * @param tasks list of tasks to set
     * */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * @return name of test
     * */
    public String getName() {
        return name;
    }

    /**
     * @param name name of c
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return description of test
     * */
    public String getDescription() {
        return description;
    }

    /**
     * @param description description of test
     * */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return PK of author in user tables
     * */
    public long getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId PK of author in user tables
     * */
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Test two tests to equals
     *
     *  @see Object#equals(Object)
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;

        Test test = (Test) o;

        if (id != test.id) return false;
        if (authorId != test.authorId) return false;
        if (name != null ? !name.equals(test.name) : test.name != null) return false;
        if (description != null ? !description.equals(test.description) : test.description != null) return false;
        if (tasks != null ? !tasks.equals(test.tasks) : test.tasks != null) return false;
        if (resultCalculationStrategyWay != test.resultCalculationStrategyWay) return false;
        if (created != null ? !created.equals(test.created) : test.created != null) return false;
        return updated != null ? updated.equals(test.updated) : test.updated == null;
    }

    /**
     * @see Object#hashCode()
     * */
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (authorId ^ (authorId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        result = 31 * result + (resultCalculationStrategyWay != null ? resultCalculationStrategyWay.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        return result;
    }

    /**
     * @return stringify {@code }
     *
     * @see Object#toString()
     * */
    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                ", resultCalculationStrategyWay=" + resultCalculationStrategyWay +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
