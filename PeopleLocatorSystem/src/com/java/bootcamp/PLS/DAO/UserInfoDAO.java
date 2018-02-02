package com.java.bootcamp.PLS.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.bootcamp.PLS.main.Constant;

//import com.java.bootcamp.PLS.Object.Employee;

public class UserInfoDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean retrieveInfo( String username, String password){
		boolean loginFound = false;
		
		try {
			// create connection
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/people_locator_system"
							+ "?user=root&password=root");
			ps = conn.prepareStatement( Constant.LOGIN_STATEMENT );
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();

			int rsSize = 0;
			
			if (rs != null) {
				rs.beforeFirst();
				rs.last();
				rsSize = rs.getRow();
			}

			if (rsSize > 0) {
				loginFound = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return loginFound;
	}
}
