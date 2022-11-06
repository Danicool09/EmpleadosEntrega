package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection con = null;
    public static Connection getConnection()
    {
        String url = "jdbc:mysql://192.168.56.101:3306/employees";
        String user = "user";
        String pass = "user";
        try {

            con = DriverManager.getConnection(url, user, pass);
        }
        catch ( SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}