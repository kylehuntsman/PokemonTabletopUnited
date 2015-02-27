package com.github.funnygopher.ptu.util;

public class Util {
	
	public static String getDisplayName(String input) {
		String firstChar = input.substring(0, 1).toUpperCase();
		String restOfString = input.substring(1).toLowerCase();
		String finalString = restOfString.replace('_', ' ');
		return firstChar + finalString;
	}
}
