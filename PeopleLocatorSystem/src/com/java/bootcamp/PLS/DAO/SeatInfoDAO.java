package com.java.bootcamp.PLS.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.bootcamp.PLS.Object.SeatInfo;
import com.java.bootcamp.PLS.main.Constant;

public class SeatInfoDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private static List<SeatInfo> seatList = new ArrayList<SeatInfo>();
	
	public List<SeatInfo> viewSeatplanByLocation(String location, String floorLevel) {
		seatList.clear();
		try {
			// Connection
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/people_locator_system"
							+ "?user=root&password=root");
			
			// Prepared Statement
			ps = conn.prepareStatement( Constant.VIEW_SEATPLAN_STATEMENT );
			ps.setString(1, location);
			ps.setString(2, floorLevel);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				seatList.add(new SeatInfo(rs.getString("seat_id"), rs.getString("name"),rs.getString("local") ));
			}	

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
		return seatList;
	}
	
	public List<SeatInfo> viewSeatplanByQuadrant(String location, String floorLevel, String quadrant) {
		seatList.clear();
		try {
			// Connection
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/people_locator_system"
							+ "?user=root&password=root");
			
			// Prepared Statement
			ps = conn.prepareStatement( "SELECT DISTINCT seat_id, CONCAT(first_name,\" \",last_name) AS name, local FROM employee AS e RIGHT JOIN seat_assignment AS sa ON e.employee_key = sa.employee_key RIGHT JOIN seat AS s ON sa.seat_key = s.seat_key WHERE  location = ? AND floor = ? AND quadrant = ? GROUP BY e.employee_id ORDER BY seat_id " );
			ps.setString(1, location);
			ps.setString(2, floorLevel);
			ps.setString(3, quadrant);
			rs = ps.executeQuery();

			while (rs.next()) {
				seatList.add(new SeatInfo(rs.getString("seat_id"), rs.getString("name"),rs.getString("local") ));
			}

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
		return seatList;
	}
}
