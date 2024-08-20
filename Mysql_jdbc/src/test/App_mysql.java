package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App_mysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con = DriverManager.getConnection
		 ("jdbc:mysql://localhost/login","root","avinash@123");
		
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