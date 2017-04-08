/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.exceptions.dao;

/**
 * @author Lomako
 * @version 1.0
 */
public class EmailConflictException extends PersistException {
    public EmailConflictException() {
    }

    public EmailConflictException(String message) {
        super(message);
    }

    public EmailConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailConflictException(Throwable cause) {
        super(cause);
    }

    public EmailConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
