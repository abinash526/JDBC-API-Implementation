package com.stackroute.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JdbcBatchDemo {
    public void getEmployeeDetailsByNameAndGender() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE", "root", "Root@123");
            PreparedStatement statement = connection.prepareStatement("Insert into EMPLOYEE  VALUES(?,?,?,?)");
            statement.setInt(1, 12);
            statement.setString(2, "Akjhj");
            statement.setString(3, "jena");
            statement.setString(4, "Male");
            statement.addBatch();
            statement.setInt(1, 12);
            statement.setString(2, "yash");
            statement.setString(3, "shankar");
            statement.setString(4, "Male");
            statement.addBatch();
            statement.setInt(1, 34);
            statement.setString(2, "jhlknl");
            statement.setString(3, "kojnoi");
            statement.setString(4, "Female");
            statement.addBatch();
            statement.executeBatch();
            // System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2));
            /*while (resultSet.next())
            {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
            }*/
            ResultSet resultSet=statement.executeQuery("Select * From EMPLOYEE");
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }

    }

}
