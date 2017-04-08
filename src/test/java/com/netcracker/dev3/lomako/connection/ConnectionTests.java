/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.netcracker.dev3.lomako.connection;

import com.netcracker.dev3.lomako.utils.ConnectionPool;
import org.apache.tomcat.jdbc.pool.PoolExhaustedException;
import org.junit.Test;

import javax.naming.NamingException;
import java.sql.SQLException;

import static org.junit.Assert.assertNotEquals;

/**
 * @author Lomako
 * @version 1.0
 */
public class ConnectionTests {

    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Test(expected = PoolExhaustedException.class)
    public void connectionPool() throws SQLException, NamingException {

        for (int i = 0; i < 150; i++) {

            System.out.printf("[%d] %s\n", i, connectionPool.getConnection());
            assertNotEquals(i, 100);

        }
    }

}
