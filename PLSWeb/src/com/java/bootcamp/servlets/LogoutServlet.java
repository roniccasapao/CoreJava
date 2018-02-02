package com.java.bootcamp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.bootcamp.utility.PagesConstant;

public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		session.invalidate();

		RequestDispatcher rd = req.getRequestDispatcher(PagesConstant.INDEX);
		rd.forward(req, resp);
	}
}
