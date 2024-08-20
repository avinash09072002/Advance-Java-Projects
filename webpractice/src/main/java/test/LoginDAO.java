package test;
import java.sql.*;

public class LoginDAO {
	public UserBean ub=null;
	public UserBean login(String uN, String pW) {
		
		try {
			Connection con=DBConnection.getCon();
			
			PreparedStatement pstm=con.prepareStatement
					("select * from UserRef66 where uname=? and pword=?");
			
			pstm.setString(1, uN);
            pstm.setString(2, pW);
            
            
            ResultSet rs=pstm.executeQuery();
            
            if(rs.next()) {
            	ub=new UserBean();
            	ub.setuName(rs.getString(1));
            	ub.setpWord(rs.getString(2));
            	ub.setfName(rs.getString(3));
            	ub.setlName(rs.getString(4));
            	ub.setAdd(rs.getString(5));
            	ub.setPhNO(rs.getLong(6));
            } // end of try
		}catch(Exception e) {
			e.printStackTrace();
		}//end of catch
		return ub;
		
		
		
	}

}
