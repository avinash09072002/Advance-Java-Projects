package test;
import java.util.*;
import java.sql.*;
public class DBcon4 {
	public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
         try(s;){
        	 try {
        		 Class.forName("oracle.jdbc.driver.OracleDriver");
      		     Connection con = DriverManager.getConnection
      				   ("jdbc:oracle:thin:@localhost:1521:orcl","system","avinash");
      		     
      		     //to insert 
      		     PreparedStatement pstm=con.prepareStatement("insert into product values(?,?,?,?)");
      		     //to display
      		     
      		     PreparedStatement pstm1=con.prepareStatement("select * from product");
      		     //select the details by code 
      		     
      		     PreparedStatement pstm2=con.prepareStatement("select * from product where pcode=?");
      		     // to update the price and qunaitity
      		     
      		     PreparedStatement pstm3=con.prepareStatement("update product set price=?,qty=qty+? where pcode=?");
      		     //to delete the record
      		     
      		     PreparedStatement pstm4=con.prepareStatement("delete from product where pcode=?");
      		     
      		     
      		     while(true) {
      		    	 System.out.println("======== choice========== ");
      		    	 System.out.println("1.insert the table "+"\n\t 2.Display all the reocrds "+"\n\t 3.Dispaly the reocord by code "+""
      		    	 +"\n\t 4.update the product price and product quantity by code ");
      		    	 System.out.println("Enter the choice");
      		    	 switch(Integer.parseInt(s.nextLine())) {
      		    	 case 1:
      		    		 System.out.println("Enter the product details");
      		    		System.out.println("Enter the product code ");
      		    		String pc=s.nextLine();
      		    		System.out.println("Enter the product name ");
      		    		String pn=s.nextLine();
      		    		System.out.println("Enter the product price ");
      		    		double pp=s.nextDouble();
      		    		System.out.println("Enter the product quantity ");
      		    		int pq=s.nextInt();
      		    		
      		    		pstm.setString(1, pc);
      		    		pstm.setString(2, pn);
      		    		pstm.setDouble(3, pp);
      		    		pstm.setInt(4, pq);
      		    		
      		    		int k=pstm.executeUpdate();
      		    		
      		    		if(k>0) {
      		    			System.out.println(k+"rows effected ");
      		    			System.out.println("record inserted ");
      		    		}
      		    		break;
      		    	
      		    	 case 2:
      		    		System.out.println("Displaying all the reocrd");
      		    		ResultSet rs1=pstm1.executeQuery();
      		    		while(rs1.next()) {
      		    			System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getDouble(3)+" "+rs1.getInt(4));
      		    		}
      		    		break;
      		    	 case 3:
      		    		System.out.println("Enter the proudct code to display the reocord");
      		    		String pc1=s.nextLine();
      		    		pstm2.setString(1, pc1);
      		    		ResultSet rs2=pstm2.executeQuery();
      		    		
      		    		if(rs2.next()) {
      		    			System.out.println(rs2.getString(1)+" "+rs2.getString(2)+" "+rs2.getDouble(3)+" "+rs2.getInt(4));
      		    			
      		    		}else {
      		    			System.out.println("Record not found");
      		    		}
      		    		break;
      		    	 case 4:
      		    		System.out.println("Enter the proudct code to update the records");
      		    		String pc2=s.nextLine();
      		    		
      		    		pstm2.setString(1, pc2);
      		    		ResultSet rs3=pstm2.executeQuery();
      		    		
      		    		if(rs3.next()) {
      		    			System.out.println("the old price is "+rs3.getDouble(3));
      		    			System.out.println("Enter the new price ");
      		    			double pp1=s.nextDouble();
      		    			System.out.println("Current quantity "+rs3.getInt(4));
      		    			System.out.println("Add the quantity ");
      		    			int pq1=Integer.parseInt(s.next());
      		    			s.nextLine();
      		    			
      		    			pstm3.setDouble(1, pp1);
      		    			pstm3.setInt(2, pq1);
      		    			pstm3.setString(3, pc2);
      		    			
      		    			int k1=pstm3.executeUpdate();
      		    			if(k1>0) {
      		    				System.out.println("record updated successfully");
      		    			}
      		    		}else {
      		    			System.out.println("record not found ");
      		    		}
      		    		break;
      		    		
      		    	 case 5:
      		    		 System.out.println("Enter the product code to delete the record");
      		    		 String pc3=s.nextLine();
      		    		 pstm2.setString(1, pc3);
      		    		 
      		    		 ResultSet rs4=pstm2.executeQuery();
      		    		 if(rs4.next()) {
      		    			 
      		    			 pstm4.setString(1, pc3);
      		    			 int k3=pstm4.executeUpdate();
      		    			 if(k3>0) {
      		    				 System.out.println("Record deleted successfully...");
      		    			 }
      		    			 
      		    		 }else {
      		    			 System.out.println("record not found");
      		    		 }
      		    		 break;
      		    	 case 6:
      		    		System.out.println("exiting ....");
      		    		System.exit(0);
      		    		break;
      		    	 
      		    	 }
      		     }
      		     
      		     
         }catch(Exception e){
        	
        	 System.out.println(e.toString());//end of try with resource
        	 e.printStackTrace();
         }
	}
}
}
