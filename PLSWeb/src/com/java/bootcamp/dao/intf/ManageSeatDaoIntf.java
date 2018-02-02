package com.java.bootcamp.dao.intf;

public interface ManageSeatDaoIntf {
	public void assignEmployeeToSeat( String input, String seatId );
	public void removeEmployeeFromSeat( String input );
}
