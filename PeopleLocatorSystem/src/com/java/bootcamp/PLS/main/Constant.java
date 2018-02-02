package com.java.bootcamp.PLS.main;

public class Constant {
	
	public static final String LOGIN = new StringBuffer()
										.append( "------------------------------------" )
										.append( "\n" )	.append( "LOGIN" ).append( "\n" )
										.append( "------------------------------------" ).toString() ;
	
	public static final String USERNAME = "Username: ";
	
	public static final String PASSWORD = "Password: ";
	
	public static final String HOME_HEADER = new StringBuffer()
										.append( "## HOME ##" ).append( "\n" )	
										.append( "------------------------------------" ).append( "\n" )
										.append( "Welcome " ).append( "FIRSTNAME " )
										.append( "LASTNAME " ).append( "[EMPLOYEE]" ).append( "!" ).append( "\n" )
										.append( "------------------------------------" ).append( "\n" )
										.toString() ;
	
	public static final String HOME_MENU = new StringBuffer()
										.append( "MENU: " ).append( "\n" )
										.append( "[1] Search" ).append( "\n" )
										.append( "[2] View Seatplan" ).append( "\n" )
										.append( "[3] Logout" ).append( "\n" )
										.append( "Input number of your choice: " )
										.toString() ;
	
	public static final String SEARCH_HEADER = new StringBuffer()
										.append( "------------------------------------" )
										.append( "## SEARCH ##" )
										.append( "------------------------------------" ).append( "\n" )
										.toString();
	
	public static final String SEARCH_MENU = new StringBuffer()
										.append( "MENU: " ).append( "\n" )
										.append( "[1] By Employee ID" ).append( "\n" )
										.append( "[2] By Lastname" ).append( "\n" )
										.append( "[3] Project" ).append( "\n" )
										.append( "Input number of your choice: " )
										.toString();
	
	public static final String SEATPLAN_MENU = new StringBuffer()
										.append( "MENU: " ).append( "\n" )
										.append( "[1] By Location - Floor level" ).append( "\n" )
										.append( "[2] By Quadrant" ).append( "\n" )
										.append( "Input number of your choice: " )
										.toString();
	
	public static final String SEARCH_BY_LASTNAME = new StringBuffer()
										.append( "\n" )
										.append( "##SEARCH-By Lastname" ).append( "\n" )
										.append( "Enter Lastname: " ).toString();
	
	public static final String MENU_ERROR = new StringBuffer()
										.append( "------------------------------------" ).append( "\n" )
										.append( "PLEASE SELECT A NUMBER FROM MENU" ).append( "\n" )
										.append( "------------------------------------" ).append( "\n" )
										.toString();
	
	public static final String NOT_FOUND_ERROR = new StringBuffer()
										.append( "\n" )
										.append( "---------------------------------------------------NO MATCH FOUND--------------------------------------------------" )
										.append( "\n" )
										.toString();
	
	public static final String LOGIN_STATEMENT = "SELECT username, password FROM user_info WHERE username = ? AND password = ?";
	
	public static final String LOGOUT = new StringBuffer()
										.append( "\n" ).append( "\n" ).append( "\n" ).append( "\n" )
										.append( "LOGOUT SUCCESSFUL" )
										.toString();
	
	public static final String RESULT_HEADER = new StringBuffer()
										.append( "-------------------------------------------------------------------------------------------------------------------" )
										.append( "\n" )
										.append(String.format("%" + (-9) + "s", "EMPLOYEE ID" )).append( " | " )
										.append(String.format("%" + (-11) + "s", "FIRSTNAME" )).append( " | " )
										.append(String.format("%" + (-11) + "s", "LASTNAME" )).append( " | " )
										.append(String.format("%" + (-11) + "s", "SEAT ID" )).append( " | " )
										.append(String.format("%" + (-11) + "s", "LOCAL" )).append( " | " )
										.append(String.format("%" + (-11) + "s", "SHIFT" )).append( " | " )
										.append(String.format("%" + (-30) + "s", "PROJECT(S)" )).append( " | " )
										.append( "\n" )
										.append( "-------------------------------------------------------------------------------------------------------------------" )
										.toString();
	
	public static final String SEARCH_BY_EMPLOYEEID_STATEMENT = new StringBuffer()
										.append( "SELECT DISTINCT e.employee_id, first_name, last_name, seat_id, local, shift, " )
										.append( "GROUP_CONCAT(DISTINCT p.projectName ORDER BY p.projectName) AS projectName " )
										.append( "FROM employee AS e                    " )
										.append( "LEFT JOIN seat_assignment AS sa ON e.employee_key = sa.employee_key " )
										.append( "LEFT JOIN seat AS s ON sa.seat_key = s.seat_key " )
										.append( "LEFT JOIN project_assignment AS pa ON e.employee_key = pa.employee_key " )
										.append( "LEFT  JOIN project AS p ON pa.project_id = p.project_id " )
										.append( "WHERE employee_id LIKE ? GROUP BY  e.employee_id").toString();

	public static final String SEARCH_BY_LASTNAME_STATEMENT = new StringBuffer()
										.append( "SELECT DISTINCT e.employee_id, first_name, last_name, seat_id, local, shift, ")
										.append( "GROUP_CONCAT(DISTINCT p.projectName ORDER BY p.projectName) AS projectName " )
										.append( "FROM employee AS e                    " )
										.append( "LEFT JOIN seat_assignment AS sa ON e.employee_key = sa.employee_key " )
										.append( "LEFT JOIN seat AS s ON sa.seat_key = s.seat_key " )
										.append( "LEFT JOIN project_assignment AS pa ON e.employee_key = pa.employee_key " )
										.append( "LEFT JOIN project AS p ON pa.project_id = p.project_id " )
										.append( "WHERE last_name LIKE ? GROUP BY  e.employee_id").toString();

	public static final String SEARCH_BY_PROJECT_STATEMENT = new StringBuffer()
										.append( "SELECT DISTINCT e.employee_id, first_name, last_name, seat_id, local, shift, " )
										.append( "GROUP_CONCAT(DISTINCT p.projectName ORDER BY p.projectName) AS projectName  " )
										.append( "FROM employee AS e " )
										.append( "LEFT JOIN seat_assignment AS sa ON e.employee_key = sa.employee_key " )
										.append( "LEFT JOIN seat AS s ON sa.seat_key = s.seat_key " )
										.append( "LEFT JOIN project_assignment AS pa ON e.employee_key = pa.employee_key " )
										.append( "LEFT JOIN project AS p ON pa.project_id = p.project_id " )
										.append( "WHERE projectName LIKE ? GROUP BY  e.employee_id").toString();
										
	public static final String VIEW_SEATPLAN_STATEMENT = new StringBuffer()
										.append( "SELECT DISTINCT seat_id, CONCAT(first_name,\" \",last_name) AS name, local FROM employee AS e " )
										.append( "LEFT JOIN seat_assignment AS sa ON e.employee_key = sa.employee_key ")
										.append( "LEFT JOIN seat AS s ON sa.seat_key = s.seat_key WHERE  location = ? AND floor = ? GROUP BY e.employee_id ORDER BY seat_id ")
										.toString();

	public static final String END_OF_RESULT = new StringBuffer()
										.append( "----------------------------------------------------END OF RESULT---------------------------------------------------" ).append( "\n" )
										.toString();

	public static final String END_OF_SEATPLAN = new StringBuffer()
										.append( "---------------------------------------------------END OF SEATPLAN--------------------------------------------------" ).append( "\n" )
										.toString();

	public static final String ACTIONS = new StringBuffer()
										.append( "ACTIONS: [1]Search Again [2]Home" )
										.append( "\n" ).append( "ACTION: " ).toString();

	public static final String ACTIONS_SEATPLAN = new StringBuffer()
										.append( "ACTIONS: [1]View Seatplan Again [2]Home" )
										.append( "\n" ).append( "ACTION: " ).toString();

}
