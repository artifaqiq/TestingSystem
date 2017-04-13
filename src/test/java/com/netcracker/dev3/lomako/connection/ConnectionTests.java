/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.connection;

import com.netcracker.dev3.lomako.utils.ConnectionPool;
import org.apache.tomcat.jdbc.pool.PoolExhaustedException;
import org.junit.Test;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotEquals;

/**
 * @author Lomako
 * @version 1.0
 */
public class ConnectionTests {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Test
    public void returningToPool() throws SQLException, NamingException {
        for (int i = 0; i < 100; i++) {
            Connection connection = connectionPool.getConnection();
            connection.close();
        }

        for (int i = 0; i < 100; i++) {
            Connection connection = connectionPool.getConnection();
            connection.close();
        }


    }

}
