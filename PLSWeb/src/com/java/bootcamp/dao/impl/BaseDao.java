package com.java.bootcamp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.bootcamp.utility.DaoConstant;

public abstract class BaseDao {
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	public Connection getConnection() throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		

		Class.forName( "com.mysql.jdbc.Driver" ).newInstance();

		conn = DriverManager.getConnection( DaoConstant.DB_HOST
				+ DaoConstant.DB_NAME + DaoConstant.DB_USER
				+ DaoConstant.DB_PASSWORD );

		return conn;
	}

	public void closeConnectionsWithoutRs( Connection conn, PreparedStatement ps ) throws SQLException {

		if ( conn != null ) {
			conn.close();
		}
		if ( ps != null ) {
			ps.close();
		}
		
	}

	public void closeConnections( Connection conn, PreparedStatement ps,
			ResultSet rs ) throws SQLException {

		if ( conn != null ) {
			conn.close();
		}
		if ( ps != null ) {
			ps.close();
		}
		if ( rs != null ) {
			rs.close();
		}
	}
}
