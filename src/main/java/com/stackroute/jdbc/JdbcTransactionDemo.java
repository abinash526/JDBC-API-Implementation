package com.stackroute.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JdbcTransactionDemo {
    public void getEmployeeDetailsByNameAndGender() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try
        {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE", "root", "Root@123");
            PreparedStatement statement = connection.prepareStatement("Insert into EMPLOYEE  VALUES(?,?,?,?)");
            connection.setAutoCommit(false);
            statement.setInt(1,12);
            statement.setString(2,"Akjhj");
            statement.setString(3,"jena");
            statement.setString(4,"Male");
            statement.addBatch();
            statement.setInt(1,12);
            statement.setString(2,"yash");
            statement.setString(3,"shankar");
            statement.setString(4,"Male");
            statement.addBatch();
            statement.executeBatch();
            // System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2));
            /*while (resultSet.next())
            {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
            }*/
            System.out.println("Do you want to commit or rollback");
            Scanner sc=new Scanner(System.in);
            String s=sc.nextLine();
            if(s.equals("commit"))
                connection.commit();
            else if(s.equals("rollback"))
            {
                connection.rollback();
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }

    }

}
