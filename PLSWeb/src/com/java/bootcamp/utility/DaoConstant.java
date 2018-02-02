package com.java.bootcamp.utility;

public class DaoConstant {
	public static final String DB_HOST = "jdbc:mysql://localhost/";
	
	public static final String DB_NAME = "casapao_people_locator_system?";
	
	public static final String DB_USER = "user=root";
	
	public static final String DB_PASSWORD = "&password=root";
	
	public static final String LOGIN_STATEMENT = new StringBuffer()
		.append( "SELECT username, password , first_name , last_name, role FROM user_info AS ui ")
		.append( "RIGHT JOIN employee AS e ON e.employee_key = ui.employee_key WHERE username = ? AND password = ?").toString();

	public static final String SEARCH_BY_NAME_STATEMENT = new StringBuffer()
		.append( "SELECT employee_id, first_name , last_name, seat_id, local " )
		.append( "FROM employee AS e LEFT JOIN seat_assignment AS sa ON e.employee_key = sa.employee_key " ) 
		.append( "LEFT JOIN seat AS s ON sa.seat_key = s.seat_key ")
		.append( "WHERE last_name LIKE ? OR first_name LIKE ? ")
		.append( "OR CONCAT (first_name , \" \" , last_name) LIKE ?").toString();

	public static final String SEARCH_BY_ID_STATEMENT = new StringBuffer()
		.append( "SELECT employee_id, first_name , last_name, seat_id, local " )
		.append( "FROM employee AS e LEFT JOIN seat_assignment AS sa ON e.employee_key = sa.employee_key " ) 
		.append( "LEFT JOIN seat AS s ON sa.seat_key = s.seat_key ")
		.append( "WHERE employee_id ")
		.append( "LIKE ?").toString();
	
	public static final String SEARCH_BY_SEATID_STATEMENT = new StringBuffer()
		.append( "SELECT employee_id, first_name , last_name, seat_id, local " )
		.append( "FROM employee AS e LEFT JOIN seat_assignment AS sa ON e.employee_key = sa.employee_key " ) 
		.append( "LEFT JOIN seat AS s ON sa.seat_key = s.seat_key ")
		.append( "WHERE seat_id LIKE ? ").toString();
	
	public static final String REMOVE_EMPLOYEE_FROM_SEAT_STATEMENT = "DELETE FROM seat_assignment WHERE employee_key in (SELECT DISTINCT employee_key FROM employee WHERE employee_id = ?)";
	
	public static final String ASSIGN_EMPLOYEE_TO_SEAT_STATEMENT = "INSERT INTO seat_assignment VALUES (DEFAULT, (SELECT DISTINCT employee_key FROM employee WHERE employee_id = ?), (SELECT DISTINCT seat_key FROM seat WHERE seat_id = ?))";


}
