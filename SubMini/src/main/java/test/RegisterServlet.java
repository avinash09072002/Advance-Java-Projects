package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/reg")

public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws
	ServletException, IOException{
		
		UserBean ub = new UserBean();
		ub.setName(req.getParameter("uname"));
		ub.setPass(req.getParameter("pword"));
		ub.setEmail(req.getParameter("email"));
		
		int k=new RegDAO().insert(ub);
		if(k>0) {
			req.setAttribute("msg", "registration successfull");
			RequestDispatcher rd= req.getRequestDispatcher("register.jsp");
			rd.forward(req, res);
		}
	}

}
