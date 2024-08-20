
// dispalying the records of employee based on its empno
package test;

import java.sql.*;
import java.util.*;

public class DBcon3 {


    public static void main(String[] args) {
        try {
        	Scanner sc= new Scanner(System.in);
        	System.out.println("Enter the employee number ");      // taking emp no as input from console 
        	int empno=sc.nextInt();
            // Loading the driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Creating connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "avinash");

            // Statement for emp1 table
            Statement stmt1 = con.createStatement();
            ResultSet rs1 = stmt1.executeQuery("SELECT * FROM emp1 where empno="+empno+"");   // rs1 collects the query result
            System.out.println("The employee details:");
            if (rs1.next()) {
                // Printing columns from emp1 table (assuming columns are ID (int), NAME (String), JOB (String), SALARY (String))
                System.out.println(rs1.getInt(1)+" "+rs1.getString(2) +" "+rs1.getString(3) );
            }else {
            	System.out.println("record not found");
            }

            // Statement for customer62 table
          con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
