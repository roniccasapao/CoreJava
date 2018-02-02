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
import com.java.bootcamp.backend.impl.SearchManagerImpl;
import com.java.bootcamp.backend.intf.SearchManagerIntf;
import com.java.bootcamp.object.Employee;
import com.java.bootcamp.utility.PagesConstant;


public class SearchServlet extends HttpServlet{
	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp )
			throws ServletException, IOException {
		
		String search = req.getParameter( "searchBox" );
		String searchOption = req.getParameter( "searchOption" );
		
		SearchManagerIntf searchManager = new SearchManagerImpl();
				
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
	protected void doGet( HttpServletRequest req, HttpServletResponse resp )
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(PagesConstant.SEARCH);
		rd.forward(req, resp);
	}
}
