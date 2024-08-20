package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/dis")
public class Servlet2 extends GenericServlet {
	
		@Override
		 public void init()throws ServletException{
			//no code
		}
		@Override
		 public void service(ServletRequest req,ServletResponse res)throws ServletException,
		 IOException{
			 String uN = req.getParameter("uname");
			 String pass=req.getParameter("password");
			 String Lname=req.getParameter("lastname");
			 String address=req.getParameter("address");
			 String md = req.getParameter("emial");
			 String pno=req.getParameter("number");
			 
			 PrintWriter pw = res.getWriter();
			 res.setContentType("text/html");
			 pw.println("======Servlet=====<br>");
			 pw.println("UserName:"+uN+"<br>");
			 pw.println("password:"+pass+"<br>");
			 pw.println("lastName:"+Lname+"<br>");
			 pw.println("address:"+address+"<br>");
			 
			 pw.println("MailId:"+md+"<br>");
			 pw.println("phoneNumber:"+pno+"<br>");
			 
		}
		@Override
		 public void destroy() {
		 //NoCode
		 }
		}
