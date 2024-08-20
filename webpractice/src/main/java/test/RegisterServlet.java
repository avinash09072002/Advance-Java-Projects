package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")

@WebServlet("/reg")

public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws
	ServletException,IOException{
		
		UserBean ub=new UserBean();
		
		ub.setuName(req.getParameter("uname"));
		ub.setpWord(req.getParameter("pword"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setAdd(req.getParameter("add"));
		ub.setPhNO(Long.parseLong(req.getParameter("phno")));
		
		
		  int k = new RegisterDAO().insert(ub);
		  
		  if(k>0) {
			  req.setAttribute("msg", "registration successfull <br>");
			  RequestDispatcher rd= req.getRequestDispatcher("register.jsp");
			  rd.forward(req, res);
		  }
		
	}

}


