package com.java.bootcamp.PLS.GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java.bootcamp.PLS.DAO.EmployeeDAO;
import com.java.bootcamp.PLS.DAO.SeatInfoDAO;
import com.java.bootcamp.PLS.DAO.UserInfoDAO;
import com.java.bootcamp.PLS.Object.Employee;
import com.java.bootcamp.PLS.Object.SeatInfo;
import com.java.bootcamp.PLS.main.Constant;

public class UserInterface {
	public static Scanner in = new Scanner(System.in);
	private static String inputChoice = "" ;
	private static int menuChoice = 0 ;
	
	public static void loginConsole (){
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		int tryLeft = 6;
		boolean continueLogin = true;
		
		System.out.println( Constant.LOGIN );
		while(continueLogin){
			
			System.out.print( Constant.USERNAME );
			String username = in.nextLine();
			System.out.print( Constant.PASSWORD );
			String password = in.nextLine();
			

			if ( userInfoDAO.retrieveInfo(username, password )){
				System.out.println("Login Successful");
				System.out.println("\n\n\n");
				continueLogin = !continueLogin;
				welcomePage();
			} else {
				System.out.println("<<LOGIN ERROR>>");
				tryLeft--;
				System.out.println("You have " + tryLeft + " tries left \n");
				if( tryLeft == 0){
					System.out.println("That was your last attempt, Sorry. Goodbye!");
					continueLogin = !continueLogin;
				}
			}
		}
	}
		
	public static void welcomePage(){
		boolean run = true;
		
		System.out.print( Constant.HOME_HEADER );
		
		while( run ){
			System.out.print( Constant.HOME_MENU );
			inputChoice = in.nextLine();
			
			try{	
				int menuChoice = Integer.parseInt(inputChoice);
				
				switch (menuChoice) {
				case 1:
					//SEARCH
					run = !run;
					System.out.println( "\n \n" );
					searchMenu();
					break;
				case 2:
					//VIEW SEATPLAN
					System.out.println( "\n \n" );
					viewSeatplanMenu();
					run = !run;
					break;
				case 3:
					//LOGOUT
					run = !run;
					System.out.println( Constant.LOGOUT );
					loginConsole();
					break;
				default:
					System.out.print( Constant.MENU_ERROR );
					break;
				}
			} catch (Exception e){
				System.out.print( Constant.MENU_ERROR );
			}	
		}
	}
	
	public static void searchMenu(){
		boolean run = true;
		
		System.out.print( Constant.SEARCH_HEADER );
		
		while( run ){
			System.out.print( Constant.SEARCH_MENU );
			inputChoice = in.nextLine();
				
			try{
				menuChoice = Integer.parseInt(inputChoice);
				
				switch (menuChoice) {
				case 1:
					//By Employee ID
					searchByEmployeeID();
					run = !run;
					break;
				case 2:
					//By Name
					searchByLastName();
					run = !run;
					break;
				case 3:
					//By Project
					searchByProject();
					run = !run;
					break;
				default:
					System.out.print( Constant.MENU_ERROR );
					break;
				}
			} catch (Exception e) {
				System.out.print( Constant.MENU_ERROR );
			}
		}
	}
	
	public static void searchByEmployeeID(){
		
		boolean search = true;
		
		while(search){
			int ctr = 1;
			EmployeeDAO employeeDAO = new EmployeeDAO();
			
			System.out.print( new StringBuffer()
								.append( "\n" )
								.append( "## SEARCH-By Employee Id ##" ).append( "\n" )
								.append( "Enter EmployeeID: " ).toString() );
			inputChoice = in.nextLine();
			
			List<Employee> employeeList = employeeDAO.retrieveByEmployeeID(inputChoice);
			
			System.out.println( new StringBuffer() .append( "\n" )
													.append( "##SEARCH RESULT-(" ).append(employeeList.size()) 
													.append( ")##" )
													.append( "\n" ));
			System.out.println( Constant.RESULT_HEADER );
			
			
			if(employeeList.size() == 0){
				System.out.println( Constant.NOT_FOUND_ERROR );
			}else {
				for(Employee employee: employeeList){
					System.out.println(new StringBuffer() .append(String.format("%" + (-3) + "s", "[" + ctr + "]"))
															.append(employee.toString()));
					ctr++;
				}
				
				System.out.print( Constant.END_OF_RESULT );
			}
			boolean ask = true;
			
			while(ask){
				System.out.print( Constant.ACTIONS );
				String action = in.nextLine();
				
				if ( action.equals("1") ){
					ask = !ask;
					searchMenu();
				} else if ( action.equals("2") ){ 
					search = !search;
					ask = !ask;
					welcomePage();
				} else {
					System.out.println( Constant.MENU_ERROR);
				}
			}
		}
	}
	
	public static void searchByLastName(){
		
		boolean search = true;
		
		while(search){
			int ctr = 1;
			EmployeeDAO employeeDAO = new EmployeeDAO();
			System.out.print( new StringBuffer()
								.append( "\n" )
								.append( "## SEARCH-By Lastname ##" ).append( "\n" )
								.append( "Enter Lastname: " ).toString() );
			inputChoice = in.nextLine();
			
			List<Employee> employeeList = employeeDAO.retrieveByLastName(inputChoice);
			
			System.out.println( new StringBuffer() .append( "\n" )
					.append( "##SEARCH RESULT-(" ).append(employeeList.size()) 
					.append( ")##" )
					.append( "\n" ));
			System.out.println( Constant.RESULT_HEADER );
			
			if(employeeList.size() == 0){
				System.out.println( Constant.NOT_FOUND_ERROR );
			}else {
				for(Employee employee: employeeList){
					System.out.println(new StringBuffer() .append(String.format("%" + (-3) + "s", "[" + ctr + "]"))
															.append(employee.toString()));
					ctr++;
				}
				System.out.print( Constant.END_OF_RESULT );
			}
			boolean ask = true;
			
			while(ask){
				System.out.print( Constant.ACTIONS );
				String action = in.nextLine();
				
				if ( action.equals("1") ){
					ask = !ask;
					searchMenu();
				} else if ( action.equals("2") ){ 
					search = !search;
					ask = !ask;
					welcomePage();
				} else {
					System.out.println( Constant.MENU_ERROR);
				}
			}
		}
	}
	
	public static void searchByProject(){
		
		boolean search = true;
		
		int ctr = 1;
		EmployeeDAO employeeDAO = new EmployeeDAO();
		System.out.print( new StringBuffer()
							.append( "\n" )
							.append( "## SEARCH-By Project name ##" ).append( "\n" )
							.append( "Enter Project name: " ).toString() );
		inputChoice = in.nextLine();
		
		List<Employee> employeeList = employeeDAO.retrieveByProjectName(inputChoice);
		
		System.out.println( new StringBuffer() .append( "\n" )
				.append( "##SEARCH RESULT-(" ).append(employeeList.size()) 
				.append( ")##" )
				.append( "\n" ));
		System.out.println( Constant.RESULT_HEADER );
		
		
		if(employeeList.size() == 0){
			System.out.println( Constant.NOT_FOUND_ERROR );
		}else {
			
			for(Employee employee: employeeList){
				System.out.println(new StringBuffer() .append(String.format("%" + (-3) + "s", "[" + ctr + "]"))
														.append(employee.toString()));
				ctr++;
			}
			System.out.print( Constant.END_OF_RESULT );
			boolean ask = true;
			
			while(ask){
				System.out.print( Constant.ACTIONS );
				String action = in.nextLine();
				
				
				if ( action.equals("1") ){
					ask = !ask;
					searchMenu();
				} else if ( action.equals("2") ){ 
					search = !search;
					ask = !ask;
					welcomePage();
				} else {
					System.out.println( Constant.MENU_ERROR);
				}
			} 
		}
	}
	
	public static void viewSeatplanMenu(){
		boolean run = true;
		
		System.out.println( "#VIEW SEATPLAN#" );
		
		while( run ){
			System.out.println( Constant.SEATPLAN_MENU );
			inputChoice = in.nextLine();
				
			try{
				menuChoice = Integer.parseInt(inputChoice);
				if (menuChoice == 1) {
					//By Location
					viewByLocation();
					run = !run;
				} else if (menuChoice == 2) {
					//By Quadrant
					viewByQuadrant();
					run = !run;
				} else {
					System.out.print( Constant.MENU_ERROR );
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.print( Constant.MENU_ERROR );
			}
		}
	}
	
	public static void viewByLocation(){
		SeatInfoDAO seatInfoDAO = new SeatInfoDAO();
		
		boolean search = true;
		boolean isNotValid = true;
		String location = "";
		String floorLevel = "";
		
		System.out.println( "## VIEW SEATPLAN - By location -  Floor Level ##" );
		
		
		while( isNotValid ){
			System.out.println( "Enter location (PTC/PIC): " );
			location = in.nextLine();
			if( location.equalsIgnoreCase("PTC" )){
				isNotValid = !isNotValid;
				floorLevel = "12";
			} else if( location.equalsIgnoreCase("PIC" )){
				
				System.out.println( "Enter floor level (2/3/4): " );
				floorLevel = in.nextLine();
				
				if( floorLevel.equals("2") || floorLevel.equals("3") || floorLevel.equals("4")){
					isNotValid = !isNotValid;
				} else {
					System.out.println( "INCORRECT FLOOR LEVEL" );
				}
			} else {
				System.out.println( "INCORRECT LOCATION" );
			}
		}
		
		List<SeatInfo> listOfSeatPosition = seatInfoDAO.viewSeatplanByLocation( location, floorLevel );
        
        List<SeatInfo> firstRowSeatAssignments = new ArrayList<SeatInfo>();
        List<SeatInfo> secondRowSeatAssignments = new ArrayList<SeatInfo>();
        
        for ( int i = 0 ; i < listOfSeatPosition.size(); i++ ){
            if ( listOfSeatPosition.get( i ).getSeatId().endsWith( "1" ) ){
                firstRowSeatAssignments.add( listOfSeatPosition.get( i ) );
            }
            else if ( listOfSeatPosition.get( i ).getSeatId().endsWith( "2" ) ){
                secondRowSeatAssignments.add( listOfSeatPosition.get( i ) );
            }
        }
        System.out.println( "## VIEW SEATPLAN ##" );
        System.out.println( new StringBuffer().append( "LOCATION: " ).append(location).append(", ").append("FLOOR: ").append( floorLevel ));
        System.out.println("------------------------------------------------------------------------------------------------------------");
        rowSeatPositionPrint( firstRowSeatAssignments );
        System.out.println( "\n" );
        rowSeatPositionPrint( secondRowSeatAssignments );
        System.out.print( Constant.END_OF_RESULT );
        
        boolean ask = true;
        
        while(ask){
        	System.out.print( Constant.ACTIONS_SEATPLAN );
			String action = in.nextLine();
			
			if ( action.equals("1") ){
				ask = !ask;
				System.out.println("\n\n\n");
				viewSeatplanMenu();
			} else if ( action.equals("2") ){ 
				search = !search;
				ask = !ask;
				System.out.println("\n\n\n");
				welcomePage();
			} else {
				System.out.println( Constant.MENU_ERROR);
			}
		}
        
    }

	public static void viewByQuadrant(){
		SeatInfoDAO seatInfoDAO = new SeatInfoDAO();
		
		boolean search = true;
		boolean isNotValid = true;
		String location = "";
		String floorLevel = "";
		String quadrant = "";
		
		while(search){
			
			System.out.println( "## VIEW SEATPLAN - By location -  Floor Level ##" );
			
			while( isNotValid ){
				System.out.println( "Enter location (PTC/PIC): " );
				location = in.nextLine();
				if( location.equalsIgnoreCase("PTC" )){
					floorLevel = "12";
					
					System.out.println( "Enter quadrant: " );
					quadrant = in.nextLine();
					
					if( quadrant.equalsIgnoreCase("A") || quadrant.equalsIgnoreCase("B") || quadrant.equalsIgnoreCase("C") || quadrant.equalsIgnoreCase("D")){
						isNotValid = false ;
					} else {
						System.out.println( "INCORRECT QUADRANT" );
					}
				
				} else if( location.equalsIgnoreCase("PIC" )){
					
					System.out.println( "Enter floor level (2/3/4): " );
					floorLevel = in.nextLine();
					
					if( floorLevel.equals("2") || floorLevel.equals("3") || floorLevel.equals("4")){
						System.out.println( "Enter quadrant: " );
						quadrant = in.nextLine();
						
						if( quadrant.equalsIgnoreCase("A") || quadrant.equalsIgnoreCase("B") || quadrant.equalsIgnoreCase("C") || quadrant.equalsIgnoreCase("D")){
							isNotValid = false ;
						} else {
							System.out.println( "INCORRECT QUADRANT" );
						}
					} else {
						System.out.println( "INCORRECT FLOOR LEVEL" );
					}
				} else {
					System.out.println( "INCORRECT LOCATION" );
				}
			}
			
	
			List<SeatInfo> listOfSeatPosition = seatInfoDAO.viewSeatplanByQuadrant(location, floorLevel, quadrant);
	        
            List<SeatInfo> firstRowSeatAssignments = new ArrayList<SeatInfo>();
            
            for ( int i = 0 ; i < listOfSeatPosition.size(); i++ ){
                firstRowSeatAssignments.add( listOfSeatPosition.get( i ) );
            }
            System.out.println( "## VIEW SEATPLAN ##" );
            System.out.println( new StringBuffer().append( "LOCATION: " ).append( location ).append(", ").append("FLOOR: ").append( floorLevel )
            										.append("QUADRANT: ").append( quadrant ));
            System.out.println("------------------------------------------------------------------------------------------------------------");
            rowSeatPositionPrintQuadrant( firstRowSeatAssignments );
            System.out.println( "\n" );
            System.out.print( Constant.END_OF_RESULT );
            
            boolean ask = true;
            
            while(ask){
            	System.out.print( Constant.ACTIONS_SEATPLAN );
				String action = in.nextLine();
				
				if ( action.equals("1") ){
					ask = !ask;
					System.out.println("\n\n\n");
					viewSeatplanMenu();
				} else if ( action.equals("2") ){ 
					search = !search;
					ask = !ask;
					System.out.println("\n\n\n");
					welcomePage();
				} else {
					System.out.println( Constant.MENU_ERROR);
				}
			}
		}
		
	}
	
	 public static void rowSeatPositionPrint( List<SeatInfo> rowSeatAssignments ){
	        int rowSize = 4;
	        StringBuffer rowSeatID = new StringBuffer();
	        StringBuffer rowName = new StringBuffer();
	        StringBuffer rowLocal = new StringBuffer();
	        
	        for ( int i = 0; i < rowSize; i++ ){
	            rowSeatID.append( rowSeatAssignments.get( i ).getSeatId() ).append( "\t\t" );
	        }
	        for ( int i = 0; i < rowSize; i++ ){
	            rowName.append( rowSeatAssignments.get( i ).getName() )
	                    .append( "\t\t" );
	        }
	        for ( int i = 0; i < rowSize; i++ ){
	            rowLocal.append( "loc. " )
	                    .append( rowSeatAssignments.get( i ).getLocal() )
	                    .append( "\t\t" );
	        }
	        System.out.println( rowSeatID );
	        System.out.println( rowName );
	        System.out.println( rowLocal );
	    }


	
    public static void rowSeatPositionPrintQuadrant( List<SeatInfo> rowSeatAssignments ){
        int rowSize = 2;
        StringBuffer rowSeatID = new StringBuffer();
        StringBuffer rowName = new StringBuffer();
        StringBuffer rowLocal = new StringBuffer();
        
        for ( int i = 0; i < rowSize; i++ ){
            rowSeatID.append( rowSeatAssignments.get( i ).getSeatId() ).append( "\t\t" );
        }
        for ( int i = 0; i < rowSize; i++ ){
            rowName.append( rowSeatAssignments.get( i ).getName() )
                    .append( "\t\t" );
        }
        for ( int i = 0; i < rowSize; i++ ){
            rowLocal.append( "loc. " )
                    .append( rowSeatAssignments.get( i ).getLocal() )
                    .append( "\t\t" );
        }
        System.out.println( rowSeatID );
        System.out.println( rowName );
        System.out.println( rowLocal );
    }
}
