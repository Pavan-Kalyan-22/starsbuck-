package com.ser;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	String username = req.getParameter("usname");
	String password = req.getParameter("pwd");
	
	//jdbc connection using servletConfig

	
	
	try {
		   
		    Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","db8831");
			String sql = "Insert into LoginInfo Values(?,?)";
			PreparedStatement Stm = con.prepareStatement(sql);
				Stm.setString(1,username);
				Stm.setString(2,password);
				int rowsInserted = Stm.executeUpdate();
				if(rowsInserted>0) {
					res.sendRedirect("https://www.starbucks.com/");
				}else {
					PrintWriter out = res.getWriter();
					out.println("<html><body><h3>Failed to register</h3></body></html>");
				
				}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
	}
}


