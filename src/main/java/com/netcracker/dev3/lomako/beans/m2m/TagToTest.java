/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.beans.m2m;

import java.io.Serializable;

/**
 * @author Lomako
 * @version 1.0
 */
public class TagToTest implements Serializable {

    private static final long serialVersionUID = -8758391158116391504L;

    private long tagId;

    private long testId;

    public TagToTest() { }

    public TagToTest(long tagId, long testId) {
        this.tagId = tagId;
        this.testId = testId;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TagToTest)) return false;

        TagToTest tagToTest = (TagToTest) o;

        if (tagId != tagToTest.tagId) return false;
        return testId == tagToTest.testId;
    }

    @Override
    public int hashCode() {
        int result = (int) (tagId ^ (tagId >>> 32));
        result = 31 * result + (int) (testId ^ (testId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TagToTest{" +
                "tagId=" + tagId +
                ", testId=" + testId +
                '}';
    }
}
