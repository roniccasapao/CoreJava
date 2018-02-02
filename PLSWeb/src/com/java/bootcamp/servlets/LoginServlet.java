package com.java.bootcamp.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.java.bootcamp.backend.impl.AuthenticationImpl;
import com.java.bootcamp.backend.intf.AuthenticationIntf;
import com.java.bootcamp.object.User;
import com.java.bootcamp.utility.Checker;
import com.java.bootcamp.utility.PagesConstant;
import com.java.bootcamp.utility.UserAgentParser;

public class LoginServlet extends HttpServlet {
	private static Logger logger = Logger.getLogger("LoginServlet.class");
	@Override
	protected void doPost( HttpServletRequest req, HttpServletResponse resp )
			throws ServletException, IOException {
//		logger.trace( "Trace Message!" );
//		logger.debug( "MCI >> doPost" );
//		logger.info( "Info Message" );
//		logger.warn( "Warn Message" );
//		logger.error( "Error Message" );
//		logger.fatal( "Fatal Message" );
		String username = req.getParameter( "username" );
		String password = req.getParameter( "password" );

		if ( username == null && password == null ) {
			RequestDispatcher rd = req.getRequestDispatcher( PagesConstant.LOGIN );
			rd.forward( req, resp );
		} else {

			HttpSession session = null;
			DateFormat dateFormat = new SimpleDateFormat("EEEEEEEEE, d MMM yyyy" );
			Calendar cal = Calendar.getInstance();

			String userAgent = req.getHeader( "User-Agent" );
			UserAgentParser userAgentParser = new UserAgentParser( userAgent );

			String browserName = userAgentParser.getBrowserName();

			boolean validEmailFormat = Checker.checkEmailPattern( username );

			if ( validEmailFormat ) {
				AuthenticationIntf auth = new AuthenticationImpl();
				User user = auth.login( username, password );
				if ( user != null ) {
					session = req.getSession( true );

					session.setAttribute( "user", user );
					session.setAttribute( "date",dateFormat.format( cal.getTime() ) );
					session.setAttribute( "browserName", browserName );
					RequestDispatcher rd = req.getRequestDispatcher( PagesConstant.WELCOME );
					rd.forward( req, resp );
				} else {
					RequestDispatcher rd = req
							.getRequestDispatcher( PagesConstant.LOGIN );
					req.setAttribute( "error", "User not Found" );
					rd.forward( req, resp );
				}

			} else {
				RequestDispatcher rd = req.getRequestDispatcher( PagesConstant.LOGIN );
				req.setAttribute( "error", "Wrong username format" );
				rd.forward( req, resp );
			}
		}
		logger.debug( "MCO >> doPost" );
	}

	@Override
	protected void doGet( HttpServletRequest req, HttpServletResponse resp )
			throws ServletException, IOException {
//		logger.debug( "MCI >> doGet" );
//		doPost( req, resp );
		RequestDispatcher rd = req.getRequestDispatcher( PagesConstant.LOGIN );
		rd.forward( req, resp );
//		logger.debug( "MCO >> doGet" );
	}

}
