package test;
 import java.sql.*;
 public class LoginDAO 
{
 public UserBean ub=null;
 public UserBean login(String uN,String pW)
    {
	 try {
		 
		 Connection con = DBConnection.getCon();//Accessing the 
		PreparedStatement ps = con.prepareStatement
		   ("select * from UserRef62 where uname=? and pword=?");
		 ps.setString(1, uN);
		 ps.setString(2, pW);
		 ResultSet rs = ps.executeQuery();
		 if(rs.next()) {
		 ub = new UserBean();//Bean-Object
		 ub.setuName(rs.getString(1));
		 ub.setpWord(rs.getString(2));
		 ub.setfName(rs.getString(3));
		 ub.setlName(rs.getString(4));
		 ub.setAddr(rs.getString(5));
		 ub.setmId(rs.getString(6));
		 ub.setPhNo(rs.getLong(7));
		 }
	 }catch(Exception e) {e.printStackTrace();}
	 return ub;
	    }
	 }
    