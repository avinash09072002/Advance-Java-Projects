package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")

public class ViewProfileServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws
	ServletException, IOException{
		
		Cookie ck[]=req.getCookies();
		
		if(ck==null) {
			req.setAttribute("msg", "session expired <br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		  
		else {
		String fName = ck[0].getValue();
		  req.setAttribute("name", fName);
		  req.getRequestDispatcher("ViewProfile.jsp").forward(req, res);
		}
	}

}
