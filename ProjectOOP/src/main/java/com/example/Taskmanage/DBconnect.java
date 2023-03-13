package com.example.Taskmanage;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
    public Connection databaselink;
    public Connection getConnection(String DBname,String DBUser,String DBPass) {

        String url = "jdbc:mysql://localhost/" + DBname;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url, DBUser,DBPass);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return databaselink;
    }
}
