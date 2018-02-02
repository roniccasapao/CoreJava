package com.java.bootcamp.dao.impl;

import java.sql.SQLException;

import com.java.bootcamp.dao.intf.ManageSeatDaoIntf;
import com.java.bootcamp.utility.DaoConstant;

public class ManageSeatDaoImpl extends BaseDao implements ManageSeatDaoIntf {

	@Override
	public void assignEmployeeToSeat( String input, String seatId ) {
		try {
			conn = getConnection();
			ps = conn.prepareStatement(DaoConstant.ASSIGN_EMPLOYEE_TO_SEAT_STATEMENT);
			ps.setString(1, input);
			ps.setString(2, seatId);
			ps.executeUpdate();
	
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnectionsWithoutRs(conn, ps);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void removeEmployeeFromSeat( String input ) {
		try {
			conn = getConnection();
			ps = conn.prepareStatement(DaoConstant.REMOVE_EMPLOYEE_FROM_SEAT_STATEMENT);
			ps.setString(1, input);
			ps.executeUpdate();

		} catch (SQLException s) {
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnectionsWithoutRs(conn, ps);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean checkIfSeatisVacant(String input){
		boolean isSeatVacant = false;
		
		
		
		return isSeatVacant;
	}

}
