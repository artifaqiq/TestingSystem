/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dto.test;

import com.netcracker.dev3.lomako.beans.task.Task;

import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public class TestDto {
    private static final long serialVersionUID = -5965469173441798469L;

    private long id;

    private String name;

    private String description;

    private List<Task> tasks;

    private int resultCalculationStrategyWay;

    public TestDto() { }

    public TestDto(long id, String name, String description, List<Task> tasks, int resultCalculationStrategyWay) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.resultCalculationStrategyWay = resultCalculationStrategyWay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public int getResultCalculationStrategyWay() {
        return resultCalculationStrategyWay;
    }

    public void setResultCalculationStrategyWay(int resultCalculationStrategyWay) {
        this.resultCalculationStrategyWay = resultCalculationStrategyWay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestDto)) return false;

        TestDto testDto = (TestDto) o;

        if (id != testDto.id) return false;
        if (resultCalculationStrategyWay != testDto.resultCalculationStrategyWay) return false;
        if (name != null ? !name.equals(testDto.name) : testDto.name != null) return false;
        if (description != null ? !description.equals(testDto.description) : testDto.description != null) return false;
        return tasks != null ? tasks.equals(testDto.tasks) : testDto.tasks == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        result = 31 * result + resultCalculationStrategyWay;
        return result;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                ", resultCalculationStrategyWay=" + resultCalculationStrategyWay +
                '}';
    }
}
