package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings({ "serial" })
@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	
	  
	  protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	ServletException, IOException{
		  
		  UserBean ub = new LoginDAO().login(req.getParameter("uname"), 
				                             req.getParameter("pword"));
		  
		  if(ub==null) {
			  req.setAttribute("msg", "Invalid Login Process...<br>");
			  req.getRequestDispatcher("Msg.jsp").forward(req, res);
		  }
		  else {
			  ServletContext sct=req.getServletContext();
			  sct.setAttribute("ubean", ub);//UserBean object reference added to Context
			  
			  Cookie ck = new Cookie("fName",ub.getfName());//Creating Cookie
			  res.addCookie(ck);//Adding Cookie to response
			  req.getRequestDispatcher("LoginSuccess.jsp").forward(req, res);
			  
			  
		  }
		
		
	}
	

}
