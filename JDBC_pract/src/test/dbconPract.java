package test;
import java.util.*;
import java.sql.*;

/*create or replace procedure p2(id1 in number ,nm out varchar2)
is 
begin
     select name into nm from pract11 where id=id1;
end;
/
 
 */


public class dbconPract {
public static void main(String[] args) {
   
		Scanner sc=new Scanner(System.in);
		
		try(sc;){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
     		     Connection con = DriverManager.getConnection
     				   ("jdbc:oracle:thin:@localhost:1521:orcl","system","avinash");
     		     
     		   
     		     
     		     CallableStatement cs2=con.prepareCall("{call p2(?,?)}");
     		     System.out.println("Enter the id");
     		     int id=sc.nextInt();
     		     
     		     cs2.setInt(1, id);
     		     
     		     
     		     cs2.registerOutParameter(2, Types.VARCHAR);
     		     cs2.execute();
     		     
     		     System.out.println("name is "+cs2.getString(2));
     		     
				
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		}
  }
}