package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    public void getEmployeeDetailsByNameAndGender() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE", "root", "Root@123");
             PreparedStatement statement = connection.prepareStatement("Select * from EMPLOYEE ");
        ){
            ResultSet resultSet=statement.executeQuery();
            System.out.println("the MySQL character set name for the given column?");
            ResultSetMetaData metaData=resultSet.getMetaData();
            System.out.println(metaData.getColumnCount());
            System.out.println("fully-qualified name of the Java class whose instances are manufactured ");
            System.out.println(metaData.getColumnClassName(1));
            System.out.println(metaData.getCatalogName(1));
            System.out.println("Column Names");
            System.out.println(metaData.getColumnName(1)+" "+metaData.getColumnName(2)+" "+metaData.getColumnName(3));
            //System.out.println();
            System.out.println("table name");
            System.out.println(metaData.getTableName(1));
            System.out.println("precession");
            System.out.println(metaData.getPrecision(1));

        }catch (Exception e){
            System.out.println(e);
        }

    }


    }
