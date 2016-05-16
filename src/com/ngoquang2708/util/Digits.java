package com.ngoquang2708.util;

public abstract class Digits {
	
	protected char[] digits;
	
	public char getDigit(int n) {
		ensureInitialized();
		rangeCheck(n);
		return digits[n];
	}
	
	private void ensureInitialized() {
		if (digits == null) {
			throw new RuntimeException("digits is not initialized");
		}
	}
	
	private void rangeCheck(int i) {
		if (i < 0 || i >= digits.length) {
			throw new IllegalArgumentException("" + i);
		}
	}

}
