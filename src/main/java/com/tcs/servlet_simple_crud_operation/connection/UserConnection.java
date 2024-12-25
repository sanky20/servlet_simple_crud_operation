package com.tcs.servlet_simple_crud_operation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class UserConnection {

    public static Connection getUserConnection() {
        try {
        	Driver driver= new Driver();
        	DriverManager.registerDriver(driver);
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet-a5", "root", "mypets@3");
        } catch (SQLException e) {
            // Use a logging framework in production
            e.printStackTrace();
            return null;
        }
    }
}
