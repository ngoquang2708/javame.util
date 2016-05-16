package com.ngoquang2708.util;

public class HexDigits extends Digits {

	public static final int UPPERCASE = 0;
	public static final int LOWERCASE = 1;
	
	private static final char[] UPPERCASE_HEX_DIGITS = {
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', /* 0x0 - 0x9 */
			'A', 'B', 'C', 'D', 'E', 'F' /* 0xa - 0xf */
	};
	
	private static final char[] LOWERCASE_HEX_DIGITS = {
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', /* 0x0 - 0x9 */
			'a', 'b', 'c', 'd', 'e', 'f' /* 0xa - 0xf */
	};

	public HexDigits(int type) {
		switch (type) {
		case HexDigits.UPPERCASE:
			digits = UPPERCASE_HEX_DIGITS;
			break;
		case HexDigits.LOWERCASE:
			digits = LOWERCASE_HEX_DIGITS;
			break;
		default:
			throw new IllegalArgumentException();	
		}
	}

	public int toInt(char h) {
		final int[] DECODING = {
				0x0, 0x1, 0x2, 0x3, 0x4, 0x5, 0x6, 0x7, 0x8, 0x9, /* '0' - '9' */
				 -1,  -1,  -1,  -1,  -1,  -1,  -1,
				0xa, 0xb, 0xc, 0xd, 0xe, 0xf, /* 'A' - 'F' */
				 -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,
				 -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,
				0xa, 0xb, 0xc, 0xd, 0xe, 0xf  /* 'a' - 'f' */
		};
		return DECODING[(0xffff & h) - '0'];
	}
	
	public byte[] toByteArray(String s) {
		return null; /* TODO */
	}
	
	public String fromByteArray(byte[] b) {
		return null; /* TODO */
	}
	
}
