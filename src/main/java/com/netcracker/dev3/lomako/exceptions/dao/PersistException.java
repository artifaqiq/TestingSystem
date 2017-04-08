/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.exceptions.dao;

/**
 * @author Lomako
 * @version 1.0
 */
public class PersistException extends Exception {
    public PersistException() {
    }

    public PersistException(String message) {
        super(message);
    }

    public PersistException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistException(Throwable cause) {
        super(cause);
    }

    public PersistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
