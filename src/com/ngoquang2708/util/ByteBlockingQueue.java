package com.ngoquang2708.util;


public class ByteBlockingQueue {

	public static final int DEFAULT_CAPACITY = 16;

	private final byte[] buffer;

	private final Object lock;
	
	private int putIndex;
	
	private int takeIndex;

	private int count;

	public ByteBlockingQueue() {
		this(DEFAULT_CAPACITY);
	}

	public ByteBlockingQueue(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException("capacity = " + capacity);
		this.buffer = new byte[capacity];
		this.lock = new Object();
		this.count = 0;
		this.putIndex = 0;
		this.takeIndex = 0;
	}

	public void put(int b) throws InterruptedException {
		synchronized (lock) {
			while (count == buffer.length)
				lock.wait();
			buffer[putIndex] = (byte) b;
	        putIndex = inc(putIndex);
	        ++count;
	        lock.notifyAll();
		}
	}
	
	public void put(byte[] buf) throws InterruptedException {
		put0(buf, 0, buf.length);
	}

	public void put(byte[] buffer, int offset, int length) throws InterruptedException {
		put0(buffer, offset, length);
	}

	public int take() throws InterruptedException {
		synchronized (lock) {
			while (count == 0)
				lock.wait();
	        byte b = buffer[takeIndex];
	        takeIndex = inc(takeIndex);
	        --count;
	        lock.notifyAll();
	        return b;
		}
	}
	
	public int take(byte[] buf) throws InterruptedException {
		return take0(buf, 0, buf.length);
	}
	
	public int take(byte[] buf, int offset, int length) throws InterruptedException {
		return take0(buf, offset, length);
	}
	
	public int size() {
		return count;
	}
	
	public int capacity() {
		return buffer.length;
	}
	
	private int inc(int i) {
		return (++i == buffer.length) ? 0 : i;
	}
	
	private int inc(int i, int n) {
		return ((i += n) == buffer.length) ? 0 : i;
	}

	private void put0(byte[] buffer, int offset, int length) throws InterruptedException {
		if (length > this.buffer.length)
			throw new IllegalArgumentException();
		synchronized (lock) {
			// Wait until we have enough room
			while (count + length > this.buffer.length)
				lock.wait();
			// Check for continuous chunk
			if (putIndex + length <= this.buffer.length) {
				System.arraycopy(buffer, offset, this.buffer, putIndex, length);
				putIndex = inc(putIndex, length);
			} else {
				int firstChunk = this.buffer.length - putIndex;
				int remainChunk = length - firstChunk;
				System.arraycopy(buffer, offset, this.buffer, putIndex, firstChunk);
				putIndex = 0;
				System.arraycopy(buffer, offset + firstChunk, this.buffer, putIndex, remainChunk);
				putIndex = remainChunk;
			}
			count += length;
			lock.notifyAll();
		}
	}

	private int take0(byte[] buffer, int offset, int length) throws InterruptedException {
		if (length > this.buffer.length)
			throw new IllegalArgumentException();
		synchronized (lock) {
			while (count == 0)
				lock.wait();
			int copySize = Math.min(this.count, length);
			if (takeIndex + copySize <= this.buffer.length) {
				System.arraycopy(this.buffer, takeIndex, buffer, offset, copySize);
				takeIndex = inc(takeIndex, copySize);
			} else {
				int firstChunk = this.buffer.length - takeIndex;
				int remainChunk = copySize - firstChunk;
				System.arraycopy(this.buffer, takeIndex, buffer, offset, firstChunk);
				takeIndex = 0;
				System.arraycopy(this.buffer, takeIndex, buffer, offset + firstChunk, remainChunk);
				takeIndex = remainChunk;
			}
			count -= copySize;
			lock.notifyAll();
			return copySize;
		}
	}

}
