package test;
import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;


@SuppressWarnings({ "serial" })
@WebServlet("/choice")

public class ChoiceServlet extends GenericServlet {
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException,
	IOException{
		String  s1= req.getParameter("s1");
		
		if(s1.equals("add")) {
			RequestDispatcher rd=req.getRequestDispatcher("ad");
			rd.forward(req, res);
			
		}else {
			RequestDispatcher rd=req.getRequestDispatcher("av");
			rd.forward(req, res);
		}
		
	}

}
