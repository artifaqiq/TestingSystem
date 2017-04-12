/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao.m2m;

import com.netcracker.dev3.lomako.beans.m2m.TagToTest;
import com.netcracker.dev3.lomako.dao.Dao;

/**
 * @author Lomako
 * @version 1.0
 */
public interface TagToTestDao extends Dao<TagToTest, Void> {
    boolean exists(long tagId, long testId);
}
