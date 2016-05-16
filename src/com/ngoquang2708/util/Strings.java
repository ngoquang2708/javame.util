package com.ngoquang2708.util;

import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class Strings {

	private Strings() {
	}

	public static byte[] toUtf8(String s) {
		byte[] result = null;
		try {
			result = s.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}
	
	public static String fromUtf8(byte[] bytes) {
		String result = null;
		try {
			result = new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String[] split(String s, char d) {
		Vector vector = new Vector();
		int begin = 0;
		for (int end; (end = s.indexOf(d, begin)) >= 0; begin = end + 1)
			vector.addElement(s.substring(begin, end));
		if (begin > 0)
			vector.addElement(s.substring(begin));
		int size = vector.size();
		if (size == 0)
			return null;
		String[] result = new String[size];
		vector.copyInto(result);
		return result;
	}

	public static String[] split(String s, String d) {
		String[] result = null;
		Vector v = new Vector();
		int dLength = d.length();
		if (dLength == 0) {
			v.addElement("");
			for (int i = 0; i < s.length(); i++) {
				v.addElement(s.substring(i, i + 1));
			}
			v.addElement("");
		} else {
			int begin = 0;
			for (int end; (end = s.indexOf(d, begin)) >= 0;
					begin = end + dLength)
				v.addElement(s.substring(begin, end));
			if (begin > 0)
				v.addElement(s.substring(begin));
		}
		if (v.size() > 0) {
			v.copyInto((result = new String[v.size()]));
		}
		return result;
	}
	
	public static boolean isWhiteSpace(char c) {
		boolean result = false;
		switch (c) {
		case ' ':
			/* fall through */
		case '\t':
			/* fall through */
		case '\n':
			/* fall through */
		case '\r':
			result = true;
			break;
		}
		return result;
	}

	public static String omitWhiteSpace(String s) {
		StringBuffer stringBuffer = new StringBuffer();
		boolean spaceFlag = true; /* Previous white space */
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (isWhiteSpace(c)) {
				if (spaceFlag) {
					continue;
				}
				stringBuffer.append(' ');
				spaceFlag = true;
			} else {
				spaceFlag = false;
				stringBuffer.append(c);
			}
		}
		return stringBuffer.toString().trim();
	}

	public static String replaceFirst(String needle, String replacement,
			String haystack) {
		int index = haystack.indexOf(needle);
		if (index >= 0) {
			StringBuffer sbuf = new StringBuffer(haystack);
			sbuf.delete(index, index + needle.length());
			sbuf.insert(index, replacement);
			return sbuf.toString();
		}
		return haystack;
	}

	public static String replaceAll(String needle, String replacement,
			String haystack) {
		StringBuffer sbuf = new StringBuffer();
		char[] chars = haystack.toCharArray();
		int length = needle.length();
		if (length == 0) {
			sbuf.append(replacement);
			for (int i = 0, l = haystack.length(); i < l; i++) {
				sbuf.append(chars[i]);
				sbuf.append(replacement);
			}
			return sbuf.toString();
		}
		int begin = 0;
		for (int end; (end = haystack.indexOf(needle, begin)) >= 0;
				begin = end + length) {
			sbuf.append(chars, begin, end - begin);
			sbuf.append(replacement);
		}
		sbuf.append(chars, begin, chars.length - begin);
		return sbuf.toString();
	}
}
