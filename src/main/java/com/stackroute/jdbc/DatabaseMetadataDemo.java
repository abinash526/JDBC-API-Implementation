package com.stackroute.jdbc;

import java.sql.*;

public class DatabaseMetadataDemo {
    private Connection connection;
    private  Statement statement;
    private ResultSet resultSet;
    public void getEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from EMPLOYEE");)
        {
            DatabaseMetaData metaData=connection.getMetaData();
            System.out.println("whether the current user can call all the procedures");
            System.out.println(metaData.allProceduresAreCallable());
            System.out.println("URL");
            System.out.println(metaData.getURL());
            System.out.println("UserName");
            System.out.println(metaData.getUserName());
            System.out.println("name of this database product");
            System.out.println(metaData.getDatabaseProductName());
            System.out.println("Database Version");
            System.out.println(metaData.getDatabaseProductVersion());
            System.out.println("Driver Name");
            System.out.println(metaData.getDriverName());

            /*Load driver and register with DriverManager*/

            /*Use DriverManager to get Connection*/
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");

//             statement = connection.createStatement();
//
//             resultSet = statement.executeQuery("Select * from employee");


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        finally {
//            try {
//                connection.close();
//                statement.close();
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

    }
}
