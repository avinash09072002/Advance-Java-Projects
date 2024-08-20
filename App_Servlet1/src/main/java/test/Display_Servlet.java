package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")  // to supress the compiler warnings
@WebServlet("/dis")         // action of form tag
public class Display_Servlet extends GenericServlet {
	
		@Override
		 public void init()throws ServletException{
			//no code
		}
		@Override
		 public void service(ServletRequest req,ServletResponse res)throws ServletException,
		 IOException{
			 String uN = req.getParameter("uname");
			 String md = req.getParameter("mid");
			 PrintWriter pw = res.getWriter();
			 res.setContentType("text/html");
			 pw.println("======Servlet=====<br>");
			 pw.println("UserName:"+uN+"<br>");
			 pw.println("MailId:"+md+"<br>");
		}
		@Override
		 public void destroy() {
		 //NoCode
		 }
		}
