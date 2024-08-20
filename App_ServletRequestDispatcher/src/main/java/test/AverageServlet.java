package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings({ "serial" })
@WebServlet("/av")
public class AverageServlet extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException,
	IOException{
		
		int val1=Integer.parseInt(req.getParameter("v1"));
		int val2=Integer.parseInt(req.getParameter("v2"));
		float result=(float)(val1+val2)/2;
		
		PrintWriter pw= res.getWriter();
		res.setContentType("text/html");
		
		pw.println("the average is "+result+"<br>");
		
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		rd.include(req, res);
		
	}

}
