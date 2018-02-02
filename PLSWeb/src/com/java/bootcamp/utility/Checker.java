package com.java.bootcamp.utility;

public class Checker {
	private static final String LOGIN_EMAIL_PATTERN = "[A-Za-z]+[\\.][A-Za-z]+@pointwest.com.ph";
	private static final String LOGIN_PATTERN = "[A-Za-z]+[\\.][A-Za-z]+";
	
	public static boolean checkEmailPattern (String username) {
		boolean validFormat = false;
		
		if (username.matches(LOGIN_EMAIL_PATTERN) || username.matches(LOGIN_PATTERN)){
			validFormat = true;
		}
		
		return validFormat;
	}
}
