package test;
import java.sql.*;

public class DBConncetion {
	
	private static Connection con=null;
	private DBConncetion() {}
	 
      static {
    	  
    	  try {
    		   Class.forName("oracle.jdbc.driver.OracleDriver");
             
    		   con=DriverManager.getConnection(DBinfo.dburl,DBinfo.uname, DBinfo.password);
    		  
    	  }catch(Exception e) {
    		  e.printStackTrace();
    	  }
      }
      
      public static Connection getCon() {
    	  return con;
      }
}


