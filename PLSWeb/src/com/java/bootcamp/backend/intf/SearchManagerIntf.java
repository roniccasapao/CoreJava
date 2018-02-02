package com.java.bootcamp.backend.intf;

import java.util.List;

import com.java.bootcamp.object.Employee;

public interface SearchManagerIntf {
	public List<Employee> searchByEmployeeName( String inputName );
	public List<Employee> searchByEmployeeId( String inputName );
	public List<Employee> searchByseatId( String inputName );
}
