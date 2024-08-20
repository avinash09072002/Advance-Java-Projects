package test;
import java.io.*;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/forwardServlet")

public class Servlet_A_ForwardCommunication extends GenericServlet {
	
	public void service(ServletRequest req, ServletResponse res )throws ServletException,
	IOException{
		RequestDispatcher  rs=req.getRequestDispatcher("Servlet_B_ForwardCommunication");
		rs.forward(req, res);
	}
	

}
