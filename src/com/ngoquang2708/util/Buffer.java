package com.ngoquang2708.util;

public class Buffer {

	protected byte[] buffer;

	public Buffer(byte[] buffer) {
		this(buffer, buffer.length);
	}
	
	public Buffer(byte[] buffer, int size) {
		this(buffer, 0, size);
	}
	
	public Buffer(byte[] buffer, int offset, int size) {
		this.buffer = new byte[size];
		System.arraycopy(buffer, offset, this.buffer, 0, size);
	}

	public byte[] getBuffer() {
		return buffer;
	}
	
	public int getSize() {
		return buffer.length;
	}
}
