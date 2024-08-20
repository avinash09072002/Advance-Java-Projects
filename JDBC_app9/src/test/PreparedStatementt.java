package test;
import java.sql.*;
import java.util.Scanner;

public class PreparedStatementt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (sc) {
            try {
                System.out.println("Enter the empno");
                int empno = sc.nextInt();
                Class.forName("oracle.jdbc.driver.OracleDriver");

                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "avinash");

                PreparedStatement ps = con.prepareStatement("select * from emp1 where empno=?");
                PreparedStatement ps1 = con.prepareStatement("update emp1 set name=? where empno=?");

                ps.setInt(1, empno);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println("The name: " + rs.getString(2));
                }

                System.out.println("Enter the employee number that you want to edit");

                int empno1 = sc.nextInt();
                sc.nextLine(); // Consume the leftover newline
                ps.setInt(1, empno1);

                ResultSet rs2 = ps.executeQuery();

                if (rs2.next()) {
                    System.out.println("The old name is: " + rs2.getString(2));
                    System.out.println("Enter the new name:");
                    String name = sc.nextLine(); // Correctly read the new name

                    ps1.setString(1, name);
                    ps1.setInt(2, empno1);

                    int k = ps1.executeUpdate();

                    if (k > 0) {
                        System.out.println("Update successful");
                    }
                } else {
                    System.out.println("Invalid employee number");
                }

                rs.close();
                rs2.close();
                ps.close();
                ps1.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
