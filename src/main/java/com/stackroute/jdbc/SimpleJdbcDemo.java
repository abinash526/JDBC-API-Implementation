package com.stackroute.jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class SimpleJdbcDemo {

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
            /*Load driver and register with DriverManager*/

            /*Use DriverManager to get Connection*/
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");

//             statement = connection.createStatement();
//
//             resultSet = statement.executeQuery("Select * from employee");

            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }


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


    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from EMPLOYEE");)
        {
            resultSet.afterLast();
            while (resultSet.previous()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }


        }
        catch (SQLException e)
        {
            System.out.println(e);
        }



    }

    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from EMPLOYEE");)
        {
            resultSet.absolute(2);
            while (resultSet.next())
            {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }


    }

    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender(String firstname,String gender) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE", "root", "Root@123");
             PreparedStatement statement = connection.prepareStatement("Select * from EMPLOYEE  WHERE firstname=? AND gender=?");
             )
        {
            statement.setString(1,firstname);
            statement.setString(2,gender);
            ResultSet resultSet=statement.executeQuery();
           // System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2));
            while (resultSet.next())
            {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }

    }
}