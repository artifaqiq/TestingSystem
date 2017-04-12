/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.exceptions.dao;

/**
 * @author Lomako
 * @version 1.0
 */
public class TagTitleUniqueConflictException extends PersistException {
    public TagTitleUniqueConflictException() {
    }

    public TagTitleUniqueConflictException(String message) {
        super(message);
    }

    public TagTitleUniqueConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public TagTitleUniqueConflictException(Throwable cause) {
        super(cause);
    }

    public TagTitleUniqueConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
