// write a program to insert the emp1 records

package test;
import java.sql.*;
import java.util.*;

public class DBcon2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		try(sc;){
		// TODO Auto-generated method stub
		 try {
		
		
		System.out.println("Ente the employee number ");
		int emp= sc.nextInt();
		System.out.println("Enter the employee name ");
		String name=sc.next();
		
		System.out.println("Enter the salary");
		Long sal= sc.nextLong();
		
		// load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// establish connection
		
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","avinash");
		
		//statement for emp1 table 
		
		Statement stm=con.createStatement();
		//collecting the return value from query (k in nothing but the number of rows affected by query)
		
		int k= stm.executeUpdate("insert into emp1 values("+emp+",'"+name+"',"+sal+")");
		
		System.out.println(+k+"row affected");
		
		if(k>0) {
			System.out.println("Inser Successfully");
		}
		
		
		}
		
		
		
		
		catch(InputMismatchException e) {
			System.out.println("please put only integer ");
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		

	}

	}
}
