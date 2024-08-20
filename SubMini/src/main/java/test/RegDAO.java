package test;
import java.sql.*;




public class RegDAO {
	public int k=0;
	public int insert(UserBean ub) {
		
		try {
			Connection con=DBConncetion.getCon();
			
			PreparedStatement stm=con.prepareStatement("insert into UserReg62 values(?,?,?)");
			
			stm.setString(1, ub.getName());
			stm.setString(2, ub.getPass());
			stm.setString(3, ub.getEmail());
			
			 k=stm.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return k;
	}

}
