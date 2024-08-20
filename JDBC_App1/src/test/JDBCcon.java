package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//or
// import java.sql.*;

public class JDBCcon {

    public static void main(String[] args) {
        try {
            // Loading the driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Creating connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "avinash");

            // Statement for emp1 table
            Statement stmt1 = con.createStatement();
            ResultSet rs1 = stmt1.executeQuery("SELECT * FROM emp1");
            System.out.println("The employee details:");
            while (rs1.next()) {
                // Printing columns from emp1 table (assuming columns are ID (int), NAME (String), JOB (String), SALARY (String))
                System.out.println(rs1.getInt(1) );
            }

            // Statement for customer62 table
            Statement stmt2 = con.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT * FROM customer62");
            System.out.println("The customer details**********:");
            while (rs2.next()) {
                // Printing columns from customer62 table (assuming columns are ID (long), NAME (String), ADDRESS (String), PHONE (String))
                System.out.println(rs2.getLong(1) + " " + rs2.getString(2) + " " + rs2.getString(3) + " " + rs2.getString(4));
            }

            // Closing the connections
            rs1.close();
            rs2.close();
            stmt1.close();
            stmt2.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
