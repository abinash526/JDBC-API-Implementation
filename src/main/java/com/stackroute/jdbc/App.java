package com.stackroute.jdbc;

import java.sql.DatabaseMetaData;
import java.sql.ResultSetMetaData;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
        simpleJdbcDemo.getEmployeeDetails();
        System.out.println("-----IN REVERSE-----");
        simpleJdbcDemo.getEmployeeDetailsInReverse();
        System.out.println("--");
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println("--");*/
        RowSetDemo rowSetDemo=new RowSetDemo();
        rowSetDemo.getEmployeeDetailsUsingJdbcRowSet();
        System.out.println("--cached--");
        rowSetDemo.getEmployeeDetailsUsingCachedRowSet();
        JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        jdbcTransactionDemo.getEmployeeDetailsByNameAndGender();
        ResultSetMetadataDemo resultSetMetadataDemo=new ResultSetMetadataDemo();
        resultSetMetadataDemo.getEmployeeDetailsByNameAndGender();
        System.out.println("----------DATABASE META DATA----------");
        DatabaseMetadataDemo databaseMetadataDemo=new DatabaseMetadataDemo();
        databaseMetadataDemo.getEmployeeDetails();
        System.out.println("-------AFTER BATCH--------");
        JdbcBatchDemo jdbcBatchDemo=new JdbcBatchDemo();
        jdbcBatchDemo.getEmployeeDetailsByNameAndGender();


    }
}
