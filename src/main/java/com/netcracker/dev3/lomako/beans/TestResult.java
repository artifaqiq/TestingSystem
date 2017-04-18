/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.beans;

import java.io.Serializable;

/**
 * @author Lomako
 * @version 1.0
 */
public class TestResult implements Serializable {

    private static final long serialVersionUID = 2119487206353310835L;

    private long id;

    private long testId;

    private long userId;

    private int points;

    private User user;

    private Test test;

    public TestResult() {
    }

    public TestResult(long id, long testId, long userId, int points, User user, Test test) {
        this.id = id;
        this.testId = testId;
        this.userId = userId;
        this.points = points;
        this.user = user;
        this.test = test;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestResult)) return false;

        TestResult that = (TestResult) o;

        if (id != that.id) return false;
        if (testId != that.testId) return false;
        if (userId != that.userId) return false;
        if (points != that.points) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return test != null ? test.equals(that.test) : that.test == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (testId ^ (testId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + points;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (test != null ? test.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                ", testId=" + testId +
                ", userId=" + userId +
                ", points=" + points +
                ", user=" + user +
                ", test=" + test +
                '}';
    }
}
