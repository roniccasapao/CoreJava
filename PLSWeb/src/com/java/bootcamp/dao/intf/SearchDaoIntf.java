package com.java.bootcamp.dao.intf;

import java.util.List;

import com.java.bootcamp.object.Employee;

public interface SearchDaoIntf {
	public List<Employee> searchByEmployeeName( String searchInput );
	public List<Employee> searchByEmployeeId( String searchInput );
	public List<Employee> searchBySeatId( String searchInput );
}
