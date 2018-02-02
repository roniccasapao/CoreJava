package com.java.bootcamp.backend.impl;

import com.java.bootcamp.backend.intf.ManageSeatManagerIntf;
import com.java.bootcamp.dao.impl.ManageSeatDaoImpl;
import com.java.bootcamp.dao.intf.ManageSeatDaoIntf;

public class ManageSeatManagerImpl implements ManageSeatManagerIntf {
	ManageSeatDaoIntf manageSeat = new ManageSeatDaoImpl();
	
	@Override
	public void assignEmployeeToSeat( String input ,String seatId) {
		manageSeat.assignEmployeeToSeat( input, seatId );
	}
	
	@Override
	public void removeEmployeeFromSeat(String input) {
		manageSeat.removeEmployeeFromSeat(input);
	}

	

}
