/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.Tag;

/**
 * @author Lomako
 * @version 1.0
 */
public interface TagDao extends Dao<Tag, Long> {
    Tag findByTitle(String title);
}
