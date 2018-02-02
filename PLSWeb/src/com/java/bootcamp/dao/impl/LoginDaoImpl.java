package com.java.bootcamp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.bootcamp.dao.intf.LoginDaoInterface;
import com.java.bootcamp.object.User;
import com.java.bootcamp.utility.DaoConstant;

public class LoginDaoImpl  extends BaseDao implements LoginDaoInterface{
	
		public User retrieveInfo( String username, String password){
			User user = new User();
			
			try {
				conn = getConnection();
				
				ps = conn.prepareStatement( DaoConstant.LOGIN_STATEMENT );
				ps.setString(1, username);
				ps.setString(2, password);
				rs = ps.executeQuery();

				if(rs.next()){
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					if(rs.getString("role").equals("Manager")){
						user.setRole("Admin");
					}
					else if (rs.getString("role").equals("Employee")) {
						user.setRole("User");
					}
				} else {
					user = null;
				}
				
			} catch (Exception e) {
				
			} finally {
				try {
					closeConnections( conn, ps, rs );
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return user;
		}
	}

