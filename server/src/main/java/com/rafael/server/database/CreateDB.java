package com.rafael.server.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    protected static boolean createDB(Connection connection){
        try {
            Statement statement = connection.createStatement();
            statement.execute("create database if not exists raf_users");
            statement.execute("use raf_users");
            statement.execute("create table if not exists users (" +
                    "  id int auto_increment unique primary key," +
                    "  first_name text not null," +
                    "  last_name text not null," +
                    "  age int not null" +
                    ");");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
