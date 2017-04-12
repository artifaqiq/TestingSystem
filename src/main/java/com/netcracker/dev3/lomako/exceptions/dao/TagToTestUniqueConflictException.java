/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.exceptions.dao;

/**
 * @author Lomako
 * @version 1.0
 */
public class TagToTestUniqueConflictException extends PersistException {
    public TagToTestUniqueConflictException() {
    }

    public TagToTestUniqueConflictException(String message) {
        super(message);
    }

    public TagToTestUniqueConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public TagToTestUniqueConflictException(Throwable cause) {
        super(cause);
    }

    public TagToTestUniqueConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
