package com.ngoquang2708.util;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class URLs {

	private URLs() {
	}

	public static String encode(String s) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0, l = s.length(); i < l; i++) {
			char c = s.charAt(i);
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')
					|| (c >= '0' && c <= '9'))
				stringBuffer.append(c);
			else if (c == ' ')
				stringBuffer.append('+');
			else if (c <= 0x007f) // other ASCII
				appendHexStr(stringBuffer, c);
			else if (c <= 0x07ff) { // non-ASCII <= 0x7ff
				appendHexStr(stringBuffer, 0xc0 | ((c >> 6)));
				appendHexStr(stringBuffer, 0x80 | ((c & 0x3f)));
			} else { // 0x7ff < c <= 0xffff
				appendHexStr(stringBuffer, 0xe0 | ((c >> 12)));
				appendHexStr(stringBuffer, 0x80 | ((c >> 6) & 0x3f));
				appendHexStr(stringBuffer, 0x80 | ((c & 0x3f)));
			}
		}
		return stringBuffer.toString();
	}
	
//	XXX public static String encode2(String s) {
//		byte[] bytes = null;
//		String result = null;
//		if ((bytes = Strings.getUTF8(s)) != null) {
//			StringBuffer stringBuffer = new StringBuffer();
//			for (int i = 0; i < bytes.length; i++) {
//				char c = (char) (0xff & bytes[i]);
//				if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ||  
//						Character.isDigit(c)) {
//					stringBuffer.append(c);
//				} else if (c == ' ') {
//					stringBuffer.append('+');
//				} else {
//					appendHexStr(stringBuffer, 0xff & c);
//				}
//			}
//			result = stringBuffer.toString();
//		}
//		return result;
//		
//	}

	public static String decode(String s) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		for (int i = 0, l = s.length(); i < l; i++) {
			char c = s.charAt(i);
			switch (c) {
			case '%':
				if (i + 2 < l) {
					byte b = 0;
					b |= (hex2dec(s.charAt(i + 1)) << 4);
					b |= (hex2dec(s.charAt(i + 2)));
					baos.write(b);
					i += 2;
				} else {
					baos.write('%');
				}
				break;
			case '+':
				baos.write(' ');
				break;
			default:
				baos.write(c);
			}
		}
		byte[] bytes = baos.toByteArray();
		String result = null;
		try {
			result = new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static void appendHexStr(StringBuffer sbuf, int n) {
		sbuf.append('%');
		if (n < 16)
			sbuf.append('0');
		sbuf.append(Integer.toHexString(n));
	}

	private static byte hex2dec(char c) {
		if (c >= '0' && c <= '9')
			return (byte) (c - '0');
		if (c >= 'A' && c <= 'F')
			return (byte) (c - 'A' + 10);
		if (c >= 'a' && c <= 'f')
			return (byte) (c - 'a' + 10);
		throw new IllegalArgumentException("Not a hex digit: " + c);
	}
	
	
}
