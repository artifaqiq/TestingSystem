/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils;

/**
 * @author Lomako
 * @version 1.0
 */
public enum Logger {
    INSTANCE;

    public static Logger getInstance() {
        return INSTANCE;
    }

    public void debug(Class sender, Object message) {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(sender);
        logger.debug(message);
    }

    public void info(Class sender, Object message) {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(sender);
        logger.info(message);
    }

    public void warn(Class sender, Object message) {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(sender);
        logger.warn(message);
    }

    public void error(Class sender, Object message) {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(sender);
        logger.error(message);
    }

    public void fatal(Class sender, Object message) {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(sender);
        logger.fatal(message);
    }
}
