package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    final String DB_URL = "jdbc:mysql://localhost:3306/car_rental";
    final String USER = "root";
    final String PASS = "root";
    Connection con;
    BaseDao(){
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
