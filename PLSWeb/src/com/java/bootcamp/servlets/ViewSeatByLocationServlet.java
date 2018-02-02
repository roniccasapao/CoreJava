package com.java.bootcamp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bootcamp.utility.PagesConstant;

public class ViewSeatByLocationServlet extends HttpServlet {
	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp )
			throws ServletException, IOException {
		
	}
	
	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp )
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(PagesConstant.VIEWSEAT);
		rd.forward(req, resp);
	}
}
