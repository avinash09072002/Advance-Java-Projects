package test;
import java.util.*;
import java.sql.*;

public class DBcon8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		Scanner sc=new Scanner(System.in);
		
		try(sc;){
			try {
				//loading driver 
				Class.forName("oracle.jdbc.driver.OracleDriver");
			
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","avinash");
				
				//for selecting the record;
				PreparedStatement ps=con.prepareStatement("select * from bank62 where accno=?");
				
				//to update the reocords
				
				PreparedStatement ps2=con.prepareCall("update bank62 set bal=bal+? where accno=?");
				
				boolean b=con.getAutoCommit();
				System.out.println("the status is "+b);
				
				con.setAutoCommit(false);//      bydefual java application autocommit everything ,which we off 
				System.out.println("Commit status:"+con.getAutoCommit());
				 Savepoint sp = con.setSavepoint();
				//=================getting details and executing the first query ==================
				System.out.println("Enter the homeAccont number ");
				long accno1=sc.nextLong();
				ps.setLong(1,accno1);
				ResultSet rs1=ps.executeQuery();
				if(rs1.next()) {         // here it check the account number of aviansh exists or not
					
					float bal=rs1.getFloat(3);  // my bank balance 1
					
					System.out.println("Enter the beneficiery Account number ");//here i checking the akash's account number is available or not
					long accno2=sc.nextLong();
					ps.setLong(1, accno2);
					ResultSet rs2=ps.executeQuery();
					   
					
					if(rs2.next()) {
						System.out.println("Enter the amount to transfered");
						float amount=sc.nextFloat();
						
						if(amount<=bal) {
							// updates accored in avinash's account (statement 1)
							ps2.setFloat(1, -amount);// deduction in my account 
							ps2.setLong(2, accno1); // the update accoured in avinash accont, bcz he send the money to akash
                           
							int k1=ps2.executeUpdate();
							
							// updates accoured in akash account (statement 2)
							ps2.setFloat(1, +amount); // addition of amount 
							ps2.setLong(2, accno2);
							int k2=ps2.executeUpdate();
							
							if(k1==1 && k2==1) {
								System.out.println("Transaction successfull...");
								System.out.println("balance of your account  "+rs2.getFloat(3));
								ps.setLong(1, accno2);
								ResultSet rs3=ps.executeQuery();
								
								
						
							
								con.commit();          // in this code we off the autocommit operation 
								                      // hence we have to commit speciically
								
							}else {
								System.out.println("Transaction failed..");
								con.rollback(sp);
								
							}
						}else {
							System.out.println("insufficient fund...");
						}
						
					}else {
						System.out.println("Account not found ");
					}
					
					
				}else {
					System.out.println("Invalid accnout number ...");
				}
				
				
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		}// end of try catch
	}

}
