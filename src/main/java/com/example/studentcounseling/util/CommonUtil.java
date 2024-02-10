package com.example.studentcounseling.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
	private static String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
	private static Pattern p = Pattern.compile(regex);
	
	public static String convertLongToString(long input) {
		String output = String.valueOf(input);
		return output;
	}

	public static boolean handleNullCheck(String input) {
		boolean flag = false;
		if (input != null && !input.trim().equals("")) {
			flag = true;
		}
		return flag;

	}

	public static boolean isPasswordFormatted(String input) {
		Matcher m = p.matcher(input);
		return m.matches();
	}
}
