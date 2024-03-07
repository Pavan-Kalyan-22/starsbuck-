package com.ser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	public static boolean validate(String username , String pwd) {
		boolean status = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "db8831");
			PreparedStatement ps = con.prepareStatement("select * from LoginInfo where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, pwd);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				status=true;
			}
			
		}catch(Exception e) {
				System.out.println(e);
			}
			return status;
		
	
		
		
	}

}
