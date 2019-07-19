package com.stackroute.jdbc;

import javax.sql.rowset.*;
import java.sql.*;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JdbcRowSetImpl;
import com.sun.rowset.WebRowSetImpl;

public class RowSetDemo {
    private Connection connection;
    private Statement statement;
    private JdbcRowSet jdbcRowSet;
    private CachedRowSet cachedRowSet;
    private WebRowSet webRowSet;
    public void getEmployeeDetailsUsingJdbcRowSet() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE", "root", "Root@123");
             Statement statement = connection.createStatement();ResultSet resultSet = statement.executeQuery("Select * from EMPLOYEE");){
            jdbcRowSet=new JdbcRowSetImpl(connection);
            jdbcRowSet.setCommand("Select * from EMPLOYEE");
            jdbcRowSet.execute();
            jdbcRowSet.addRowSetListener(new ActionListerRowSet());
            jdbcRowSet.absolute(0);
            while (jdbcRowSet.next())
            {
                System.out.println("Id: " + jdbcRowSet.getInt(1) + " Name: " + jdbcRowSet.getString(2));
            }



        }catch (SQLException e){
            System.out.println(e);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
    public void getEmployeeDetailsUsingCachedRowSet() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE", "root", "Root@123");
             statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from EMPLOYEE");
             cachedRowSet=new CachedRowSetImpl();
             cachedRowSet.populate(resultSet);

            /*cachedRowSet.setUrl("jdbc:mysql://localhost:3306/EMPLOYEE");
            cachedRowSet.setUsername("root");
            cachedRowSet.setPassword("Root@123");
            cachedRowSet.setCommand("Select * from EMPLOYEE");
            cachedRowSet.setCommand("Select * from EMPLOYEE");
            cachedRowSet.execute();*/
            cachedRowSet.addRowSetListener(new ActionListerRowSet());
            while (cachedRowSet.next())
            {
                System.out.println("Id: " + cachedRowSet.getInt(1) + " Name: " + cachedRowSet.getString(2));
            }




        }catch (SQLException e){
            System.out.println(e);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

}
