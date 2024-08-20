package test;
import java.io.*;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("unused")
@WebServlet("/forwardServlet")

public class Servlet_B_ForwardCommunication extends GenericServlet{
	
   public void service(ServletRequest req, ServletResponse res) throws ServletException,
   IOException{
	   PrintWriter pw=res.getWriter();
	   res.setContentType("text/html");
	   pw.println("<html><body>");
   }
}
