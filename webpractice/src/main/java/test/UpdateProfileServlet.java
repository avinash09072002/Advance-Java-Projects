package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/update")

public class UpdateProfileServlet extends HttpServlet{
	   protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	   ServletException,IOException{
		   Cookie ck[] = req.getCookies();
		   
		   if(ck==null) {
			   req.setAttribute("msg", "Session Expired...<br>");
			   req.getRequestDispatcher("Msg.jsp").forward(req, res);
			   }else {
				   String fName = ck[0].getValue();
				   req.setAttribute("name", fName);
				   
				   ServletContext sct= req.getServletContext();
				   
				   UserBean ub=(UserBean)sct.getAttribute("ubean");
				   
				   ub.setAdd(req.getParameter("add"));
				   ub.setPhNO(Long.parseLong(req.getParameter("phno")));
				   
			    int k= new UpdateDAO().update(ub);
				   if(k>0) {
					   
					   req.setAttribute("msg", "update Succesffully ");
					   req.getRequestDispatcher("UpdateProfile.jsp").forward(req, res);
					   
				   }
			   
			   }

}
}
