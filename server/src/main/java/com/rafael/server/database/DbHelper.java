package com.rafael.server.database;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DbHelper {

    private static final Connection connection = getConnection();
    private static Connection getConnection() {
        try {

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/",
                    ImplMysqlLogin.getU(),
                    ImplMysqlLogin.getP()
            );
            CreateDB.createDB(connection);
            System.out.println("Connection successful");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

   public static boolean addUsers(String firstName, String lastName, int age){
        String sql = "INSERT INTO users(first_name, last_name, age) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            System.out.println(firstName + " " + lastName + " " + age + " success");
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static List<String> getUsersList(){
        List<String> listUser = new LinkedList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select first_name, last_name, age from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                listUser.add("'first_name': '" + resultSet.getString(1) +
                        "', 'last_name': '" + resultSet.getString(2) +
                        "', 'age': '" + resultSet.getInt(3) + "'");
            }

            return listUser;

        } catch (SQLException e) {
            e.printStackTrace();
            return listUser;
        }
    }
}
