/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.beans.tag;

import com.netcracker.dev3.lomako.beans.test.Test;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public class Tag implements Serializable {

    private static final long serialVersionUID = -9145068905373653019L;

    private long id;

    private String title;

    private List<Test> tests;

    public Tag() { }

    public Tag(long id, String title, List<Test> tests) {
        this.id = id;
        this.title = title;
        this.tests = tests;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;

        Tag tag = (Tag) o;

        if (id != tag.id) return false;
        if (title != null ? !title.equals(tag.title) : tag.title != null) return false;
        return tests != null ? tests.equals(tag.tests) : tag.tests == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (tests != null ? tests.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tests=" + tests +
                '}';
    }
}
