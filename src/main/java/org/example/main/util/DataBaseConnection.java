package org.example.main.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public class DataBaseConnection {

    private static final String url ="jdbc:mysql://localhost:3306/project";
    private static final String user ="root";
    private static final String pass ="santiago258";

    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException {
        if(pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(user);
            pool.setPassword(pass);

            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(10);
            pool.setMaxTotal(10);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
