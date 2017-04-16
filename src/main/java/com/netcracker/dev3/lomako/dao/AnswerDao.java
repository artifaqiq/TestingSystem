/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.dao;

import com.netcracker.dev3.lomako.beans.Answer;

import java.util.List;

/**
 * @author Lomako
 * @version 1.0
 */
public interface AnswerDao extends Dao<Answer, Long> {
    List<Answer> findByTaskId(long taskId);
}
