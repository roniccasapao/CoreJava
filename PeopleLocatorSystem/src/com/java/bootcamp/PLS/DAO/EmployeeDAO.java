package com.java.bootcamp.PLS.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.bootcamp.PLS.Object.Employee;
import com.java.bootcamp.PLS.main.Constant;

public class EmployeeDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private static List<Employee> employeeList = new ArrayList<Employee>();
	
	
	public List<Employee> retrieveByEmployeeID( String employee_id ) {
		 employeeList.clear();
		try {
			// Connection
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/people_locator_system"
							+ "?user=root&password=root");
			// Prepared Statement
			ps = conn.prepareStatement( Constant.SEARCH_BY_EMPLOYEEID_STATEMENT );
			ps.setString(1, "%" + employee_id + "%");
			rs = ps.executeQuery();
			addToList(rs);

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
		return employeeList;
	}
	
	public List<Employee> retrieveByLastName( String lastname ) {
		 employeeList.clear();
		try {
			// Connection
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/people_locator_system"
							+ "?user=root&password=root");
			// Prepared Statement
			ps = conn.prepareStatement( Constant.SEARCH_BY_LASTNAME_STATEMENT );
			ps.setString(1, "%" + lastname + "%");
			rs = ps.executeQuery();
			addToList(rs);

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
		return employeeList;
	}
	
	public List<Employee> retrieveByProjectName( String projectName ) {
		 employeeList.clear();
		try {
			// Connection
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/people_locator_system"
							+ "?user=root&password=root");
			// Prepared Statement
			ps = conn.prepareStatement( Constant.SEARCH_BY_PROJECT_STATEMENT  );
			ps.setString(1, "%" + projectName + "%");
			rs = ps.executeQuery();
			addToList(rs);

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
		return employeeList;
	}
	
	public void addToList(ResultSet rs) {
		try {
			while (rs.next()) {
				employeeList.add(new Employee(rs.getString("employee_id"), rs.getString("first_name"),rs.getString("last_name"), 
						rs.getString("seat_id"), rs.getString("local"), rs.getString("shift"), rs.getString("projectName")));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
