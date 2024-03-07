package com.ser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession ses = req.getSession();
		String name = req.getParameter("name");
		ses.setAttribute("name",name);
		String pass = req.getParameter("pass");
		if(LoginDao.validate(name,pass)) {
			res.sendRedirect("https://www.starbucks.com/");
			req.getRequestDispatcher("welcome").include(req, res);
		}else {
			out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' type='text/css' href='css/style.css'>"); // Link to external CSS file
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='error-container'>"); // Add container with error-container class
            out.println("<div class='error-message'>Username or Password incorrect</div>");
            out.println("</div>"); // Close error-container
            out.println("</body>");
            out.println("</html>");
			req.getRequestDispatcher("index.html").include(req, res);
		}
		}
	}



