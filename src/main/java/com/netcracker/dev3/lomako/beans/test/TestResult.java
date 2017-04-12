/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.beans.test;

/**
 * @author Lomako
 * @version 1.0
 */
public class TestResult {
    private long id;

    private long testId;

    private long userId;

    private int points;

    public TestResult() { }

    public TestResult(long id, long testId, long userId, int points) {
        this.id = id;
        this.testId = testId;
        this.userId = userId;
        this.points = points;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestResult)) return false;

        TestResult that = (TestResult) o;

        if (id != that.id) return false;
        if (testId != that.testId) return false;
        if (userId != that.userId) return false;
        return points == that.points;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (testId ^ (testId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + points;
        return result;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                ", testId=" + testId +
                ", userId=" + userId +
                ", points=" + points +
                '}';
    }
}
