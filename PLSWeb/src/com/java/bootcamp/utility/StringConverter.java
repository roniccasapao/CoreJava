package com.java.bootcamp.utility;

public class StringConverter {
	public static String NullConverter(String input){
		if(input == null){
			input = "None";
		}
		return input;
	}
}
