package com.ser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class welcome
 */
@WebServlet("/welcome")
public class welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	 
	PrintWriter out = res.getWriter();
	out.println("<form action = 'loginServlet' method = 'post'>");
	 out.println("</br>Welcome user");
	out.println("<input type='submit' value='logout' formaction='index.html'>");
	 out.println("</form>");
	 
 }

}
