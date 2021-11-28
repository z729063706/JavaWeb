package com.zyh.util;

import java.beans.PropertyVetoException;
import java.sql.*;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.*;

public class c3p0Util {
    
    
    private static DataSource dataSource = getDS();

    private static DataSource getDS(){
        //ComboPooledDataSource ds = new ComboPooledDataSource("mysql");
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/haikang");
        ds.setUser("root");
        ds.setPassword("zzzyyyhhh");
        ds.setInitialPoolSize(10);
        ds.setMinPoolSize(5);
        ds.setMaxPoolSize(100);
        ds.setMaxIdleTime(30);
        ds.setAcquireIncrement(5);
        ds.setDebugUnreturnedConnectionStackTraces(false);//无法读到配置文件,不知原因
        return ds;
    }
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static int closeAll(Connection conn, Statement stmt){
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
    public static int closeAll(Connection conn, PreparedStatement prst){
        try {
            prst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
}