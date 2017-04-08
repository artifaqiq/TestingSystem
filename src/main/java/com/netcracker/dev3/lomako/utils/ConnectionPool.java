/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.utils;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Lomako
 * @version 1.0
 */
public enum ConnectionPool {
    INSTANCE;

    public static ConnectionPool getInstance() {
        return INSTANCE;
    }

    private static DataSource datasource;

    static {
        PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:mysql://localhost:3306/testing_system");
        p.setDriverClassName("com.mysql.jdbc.Driver");
        p.setUsername("dev3_lomako");
        p.setPassword("ZserdXCftygV");
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        datasource = new DataSource();
        datasource.setPoolProperties(p);
    }

    public Connection getConnection() throws SQLException {
        return datasource.getConnection();
    }
}
