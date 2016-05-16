package com.ngoquang2708.util;

public class ASCIIs {

	private ASCIIs() {
	}

	public static boolean isAscii(char c) {
		return (c >= 0 && c <= 127);
	}
	
	public static boolean isAscii(String s) {
		boolean result = true;
		int n = s.length();
		if (n > 0) {
			for (int i = 0; i < n; i++) {
				char c = s.charAt(i);
				if (!isAscii(c)) {
					result = false;
					break;
				}
			}
		} else {
			result = false;
		}
		return result;
	}
	
	public static boolean isAlpha(char c) {
		boolean result = false;
		if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
			result = true;
		}
		return result;
	}
	
	public static boolean isAlpha(String s) {
		boolean result = true;
		int n = s.length();
		if (n > 0) {
			for (int i = 0; i < n; i++) {
				char c = s.charAt(i);
				if (!isAlpha(c)) {
					result = false;
					break;
				}
			}
		} else {
			result = false;
		}
		return result;
	}
	
	public static boolean isNumber(char c) {
		return Character.isDigit(c);
	}
	
	public static boolean isNumber(String s) {
		boolean result = true;
		int n = s.length();
		if (n > 0) {
			for (int i = 0; i < n; i++) {
				char c = s.charAt(i);
				if (!isNumber(c)) {
					result = false;
					break;
				}
			}
		} else {
			return false;
		}
		return result;
	}
	
	public static boolean isAlphaNumeric(char c) {
		return isAlpha(c) || isNumber(c);
	}
	
	public static boolean isAlphaNumeric(String s) {
		boolean result = true;
		int n = s.length();
		if (n > 0) {
			for (int i = 0; i < n; i++) {
				char c = s.charAt(i);
				if (!isAlphaNumeric(c)) {
					result = false;
					break;
				}
			}
		} else {
			result = false;
		}
		return result;
	}
	
	public static char toUpperCase(char c) {
		char result = c;
		if (isAscii(c)) {
			result = Character.toUpperCase(c);
		}
		return result;
	}
	
	public static String toUpperCase(String s) {
		String result = s;
		int n = s.length();
		if (n > 0) {
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < n; i++) {
				char c = s.charAt(i);
				if (isAscii(c)) {
					stringBuffer.append(Character.toUpperCase(c));
				} else {
					stringBuffer.append(c);
				}
			}
			result = stringBuffer.toString();
		}
		return result;
	}
	
	public static char toLowerCase(char c) {
		char result = c;
		if (isAscii(c)) {
			result = Character.toLowerCase(c);
		}
		return result;
	}
	
	public static String toLowerCase(String s) {
		String result = s;
		int n = s.length();
		if (n > 0) {
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < n; i++) {
				char c = s.charAt(i);
				if (isAscii(c)) {
					stringBuffer.append(Character.toLowerCase(c));
				} else {
					stringBuffer.append(c);
				}
			}
			result = stringBuffer.toString();
		}
		return result;
	}
	

}
