package test;
import java.sql.*;

public class RegisterDAO  {
	
	public int k=0;
	
	public int insert(UserBean ub) {
		
		try {
			Connection con=DBConnection.getCon();
			
			PreparedStatement stm=con.prepareStatement("insert into UserRef66 values(?,?,?,?,?,?)");
			
			stm.setString(1, ub.getuName());
			stm.setString(2, ub.getpWord());
			stm.setString(3,ub.getfName());
			stm.setString(4, ub.getlName());
			stm.setString(5,ub.getAdd());
			stm.setLong(6, ub.getPhNO());
			
			
			 k=stm.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
		
		
		
		
	}
	

}
