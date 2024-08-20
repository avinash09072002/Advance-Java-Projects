package test;
import java.io.*;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/dis")

public class Pract extends GenericServlet {
	@Override
	public void init() throws ServletException{
		
		
	}
	@Override
	 public void service(ServletRequest req,ServletResponse res)throws ServletException,
	 IOException{
		 String uN = req.getParameter("custId");
		 String md = req.getParameter("number");
		 PrintWriter pw = res.getWriter();
		 res.setContentType("text/html");
		 pw.println("======Servlet=====<br>");
		 pw.println("customerid:"+uN+"<br>");
		 pw.println("phone:"+md+"<br>");
	}
	
	

}
