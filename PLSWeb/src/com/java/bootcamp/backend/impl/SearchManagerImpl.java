package com.java.bootcamp.backend.impl;

import java.util.List;

import com.java.bootcamp.backend.intf.SearchManagerIntf;
import com.java.bootcamp.dao.impl.SearchDaoImpl;
import com.java.bootcamp.dao.intf.SearchDaoIntf;
import com.java.bootcamp.object.Employee;

public class SearchManagerImpl implements SearchManagerIntf {
	
	SearchDaoIntf searchDao = new SearchDaoImpl();
	
	@Override
	public List<Employee> searchByEmployeeName( String inputName ) {
		List<Employee> result = searchDao.searchByEmployeeName( inputName );
		return result;
	}

	@Override
	public List<Employee> searchByEmployeeId( String inputName ) {
		List<Employee> result = searchDao.searchByEmployeeId( inputName );
		return result;
	}

	@Override
	public List<Employee> searchByseatId( String inputName ) {
		List<Employee> result = searchDao.searchBySeatId( inputName );
		return result;
	}

}
