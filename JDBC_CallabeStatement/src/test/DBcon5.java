//using  callable statement , insert the records in three tables using the procudure.

package test;
import java.util.*;
import java.sql.*;

public class DBcon5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         // loading driver 
		Scanner s= new Scanner(System.in);
		
		try(s;){
			try {
				System.out.println("Enter the AccNo:");
				long accNo = Long.parseLong(s.nextLine());
				System.out.println("Enter the Name");
				String name = s.nextLine();
				System.out.println("Enter the Balance:");
				float bal = Float.parseFloat(s.nextLine());
				System.out.println("Enter the AccType:");
				String accType = s.nextLine();
				System.out.println("Enter the HNo:");
				String hNo = s.nextLine();
				System.out.println("Enter the StreetName:");
				String sName = s.nextLine();
				System.out.println("Enter the City:");
				String city = s.nextLine();
				System.out.println("Enter the State:");
				String state = s.nextLine();
				System.out.println("Enter the PinCode:");
				int pinCode = Integer.parseInt(s.nextLine());
				System.out.println("Enter the MailId:");

				String mId = s.nextLine();
				System.out.println("Enter the PhoneNo:");
				long phNo = Long.parseLong(s.nextLine());
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","avinash");
				CallableStatement cs = con.prepareCall
						("{call BankCustomer62(?,?,?,?,?,?,?,?,?,?,?)}");
				
				cs.setLong(1, accNo);
				cs.setString(2, name);
				cs.setFloat(3, bal);
				cs.setString(4, accType);
				cs.setString(5, hNo);
				cs.setString(6, sName);
				cs.setString(7, city);
				cs.setString(8, state);
				cs.setInt(9, pinCode);
				cs.setString(10, mId);
				cs.setLong(11, phNo);
				cs.execute();
				System.out.println("Procedure executed Successfully...");
				con.close();
				
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		}
	}

}

//create or replace procedure BankCustomer62
//(ano number,nm varchar2,bal number,atype varchar2,hn varchar2,sn varchar2,cty varchar2,
//st varchar2,pcode number,md varchar2,pno number) is
//begin
//insert into CustData62 values(ano,nm,bal,atype);
//insert into CustAddress62 values(ano,hn,sn,cty,st,pcode);
//insert into CustContact62 values(ano,md,pno);
//end;
///
