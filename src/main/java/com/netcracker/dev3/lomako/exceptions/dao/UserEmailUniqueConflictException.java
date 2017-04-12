/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.exceptions.dao;

/**
 * @author Lomako
 * @version 1.0
 */
public class UserEmailUniqueConflictException extends PersistException {
    public UserEmailUniqueConflictException() {
    }

    public UserEmailUniqueConflictException(String message) {
        super(message);
    }

    public UserEmailUniqueConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserEmailUniqueConflictException(Throwable cause) {
        super(cause);
    }

    public UserEmailUniqueConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
