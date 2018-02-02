package com.java.bootcamp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.bootcamp.dao.intf.SearchDaoIntf;
import com.java.bootcamp.object.Employee;
import com.java.bootcamp.utility.DaoConstant;
import com.java.bootcamp.utility.StringConverter;

public class SearchDaoImpl extends BaseDao implements SearchDaoIntf {

	private List<Employee> employeeList = new ArrayList<Employee>();
	
	@Override
	public List<Employee> searchByEmployeeName( String searchInput ) {
		try {
			conn = getConnection();
			
			ps = conn.prepareStatement(DaoConstant.SEARCH_BY_NAME_STATEMENT);
			ps.setString(1, "%" + searchInput + "%");
			ps.setString(2, "%" + searchInput + "%");
			ps.setString(3, "%" + searchInput + "%");
			rs = ps.executeQuery();
			addToList(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnections( conn, ps, rs );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return employeeList;
	}

	@Override
	public List<Employee> searchByEmployeeId( String searchInput ) {
		try {
			conn = getConnection();
			
			ps = conn.prepareStatement(DaoConstant.SEARCH_BY_ID_STATEMENT);
			ps.setString(1, "%" + searchInput + "%");
			rs = ps.executeQuery();
			addToList(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnections( conn, ps, rs );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return employeeList;
	}

	@Override
	public List<Employee> searchBySeatId( String searchInput ) {
		try {
			conn = getConnection();
			
			ps = conn.prepareStatement(DaoConstant.SEARCH_BY_SEATID_STATEMENT);
			ps.setString(1, "%" + searchInput + "%");
			rs = ps.executeQuery();
			addToList(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnections( conn, ps, rs );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return employeeList;
	}
	
	public void addToList(ResultSet rs) {
		try {
			while (rs.next()) {
				employeeList.add(new Employee(StringConverter.NullConverter(rs.getString("employee_id")), 
											StringConverter.NullConverter(rs.getString("first_name")), 
											StringConverter.NullConverter(rs.getString("last_name")), 
											StringConverter.NullConverter( rs.getString( "seat_id" ) )));
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
