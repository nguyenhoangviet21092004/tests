package com.example.demo8;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static final String Url = "jdbc:mysql://localhost:3306/QuanLyTaiChinh";
    private static final String username = "root";
    private static final String password = "t18032004";
    public static java.sql.Connection connection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection connection = DriverManager.getConnection(Url, username, password);
        return connection;
     }

}