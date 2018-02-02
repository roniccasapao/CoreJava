package com.java.bootcamp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.java.bootcamp.backend.impl.ManageSeatManagerImpl;
import com.java.bootcamp.backend.impl.SearchManagerImpl;
import com.java.bootcamp.backend.intf.ManageSeatManagerIntf;
import com.java.bootcamp.backend.intf.SearchManagerIntf;
import com.java.bootcamp.object.Employee;
import com.java.bootcamp.utility.PagesConstant;

public class ManageSeatServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter( "action" );
		String employeeId = req.getParameter( "employeeId" );
		String seatId = req.getParameter( "seatId" );
		String search = req.getParameter( "searchBox" );
		String searchOption = req.getParameter( "searchOption" );
		
		ManageSeatManagerIntf manageSeat = new ManageSeatManagerImpl();
		SearchManagerIntf searchManager = new SearchManagerImpl();
		
		if(action.equals( "add" )){
			manageSeat.assignEmployeeToSeat( employeeId, seatId );
		} else if(action.equals( "remove" )){
			manageSeat.removeEmployeeFromSeat(employeeId);
		} else if(action.equals( "move" )){
			manageSeat.removeEmployeeFromSeat(employeeId);
			manageSeat.assignEmployeeToSeat( employeeId, seatId );
		}
		
		if( searchOption.equals("byId") ){
			
			List<Employee> resultById = new ArrayList<Employee>();
			resultById = searchManager.searchByEmployeeId( search );
			 
			Gson gson = new Gson();
			String jsonText = gson.toJson( resultById );
			PrintWriter writer = resp.getWriter();

			writer.print( jsonText );
			
		} else if( searchOption.equals("byName") ){

			List<Employee> resultByName = new ArrayList<Employee>();
			resultByName = searchManager.searchByEmployeeName( search );
			 
			Gson gson = new Gson();
			String jsonText = gson.toJson( resultByName );
			PrintWriter writer = resp.getWriter();

			writer.print( jsonText );
		} 
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(PagesConstant.MANAGESEAT);
		rd.forward(req, resp);
	}
}
