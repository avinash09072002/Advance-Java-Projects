package test;
import java.io.*;


import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings({ "serial" })
@WebServlet("/ad")
public class addServlet extends GenericServlet{
	
	public void service(ServletRequest req, ServletResponse res) throws ServletException,
	IOException{
		int val1=Integer.parseInt(req.getParameter("v1"));
		int val2=Integer.parseInt(req.getParameter("v2"));
		
		int result=val1+val2;
		
		PrintWriter pw= res.getWriter();
		res.setContentType("text/html");
		pw.println("the sum is "+result+"<br>");
		
		RequestDispatcher rd= req.getRequestDispatcher("input.html");
		rd.include(req, res);
		
		
	}

}
