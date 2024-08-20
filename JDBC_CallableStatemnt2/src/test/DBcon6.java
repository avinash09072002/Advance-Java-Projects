//fetch the reocord from custData62 according to account number  table using the procedure in which take accNO is in parameter 

package test;
import java.sql.*;
import java.util.*;

public class DBcon6 {

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Enter the AccNo:");
            long accNo = s.nextLong();

            // Use try-with-resources for Connection and CallableStatement to ensure they are closed properly
            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "avinash");
                 CallableStatement cs = con.prepareCall("{call RetrieveCustData62(?,?,?,?)}")) {
                
                cs.setLong(1, accNo);
                cs.registerOutParameter(2, Types.VARCHAR);
                cs.registerOutParameter(3, Types.NUMERIC); // Use NUMERIC instead of BIGINT
                cs.registerOutParameter(4, Types.VARCHAR);

                // Execute the stored procedure
                cs.execute();

                // Retrieve the output parameters
                String name = cs.getString(2);
                long balance = cs.getLong(3); // Use getLong for numeric values
                String status = cs.getString(4);

                System.out.println("Procedure executed Successfully...");
                System.out.println("Name: " + name);
                System.out.println("Balance: " + balance);
                System.out.println("Status: " + status);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
