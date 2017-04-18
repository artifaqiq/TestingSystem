/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.TagToTest;

import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public interface TagToTestDao extends Dao<TagToTest, Void> {
    boolean exists(long tagId, long testId);

    List<TagToTest> findByTestId(long testId);

    List<TagToTest> findByTagId(long tagId);


}
