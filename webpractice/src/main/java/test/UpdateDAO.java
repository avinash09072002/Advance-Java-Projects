package test;
import java.sql.*;



public class UpdateDAO {
	
	int k=0;
	
	public int update( UserBean ub) {
		
           try {
       		Connection con= DBConnection.getCon();
       		PreparedStatement pstm= con.prepareStatement("update UserRef66 set addr=?, phno=? where uname=? and pword=? ");
       		
       		pstm.setString(1, ub.getAdd());
       		pstm.setLong(2, ub.getPhNO());
       		pstm.setString(3, ub.getuName());
       		pstm.setString(4, ub.getpWord());
       		
       		
       		 k= pstm.executeUpdate();

           }catch(Exception e) {
        	   e.printStackTrace();
           }
		
		return k;
	}

}
