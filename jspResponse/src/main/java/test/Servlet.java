package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/dis")

public class Servlet extends GenericServlet {
	
	public void service(ServletRequest req, ServletResponse res) throws ServletException ,
	IOException{
		
		RequestDispatcher ds=req.getRequestDispatcher("/Response.jsp");
		ds.forward(req, res);
	}

}
