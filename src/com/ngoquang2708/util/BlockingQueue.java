package com.ngoquang2708.util;

public class BlockingQueue {

	private final Object[] elements;

	private final Object lock;
	
	private int putIndex;
	
	private int takeIndex;

	private int count;

	public BlockingQueue(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException("capacity = " + capacity);
		this.elements = new Object[capacity];
		this.lock = new Object();
		this.count = 0;
		this.putIndex = 0;
		this.takeIndex = 0;
	}

	public void put(Object in) throws InterruptedException {
		synchronized (lock) {
			while (count == elements.length)
				lock.wait();
			elements[putIndex] = in;
	        putIndex = inc(putIndex);
	        ++count;
	        lock.notifyAll();
		}
	}
	
	public void put(Object[] in) throws InterruptedException {
		put0(in, 0, in.length);
	}

	public void put(Object[] out, int offset, int length) throws InterruptedException {
		put0(out, offset, length);
	}

	public Object take() throws InterruptedException {
		synchronized (lock) {
			while (count == 0)
				lock.wait();
	        Object e = elements[takeIndex];
	        takeIndex = inc(takeIndex);
	        --count;
	        lock.notifyAll();
	        return e;
		}
	}
	
	public int take(Object[] out) throws InterruptedException {
		return take0(out, 0, out.length);
	}
	
	public int take(Object[] out, int offset, int length) throws InterruptedException {
		return take0(out, offset, length);
	}
	
	public int size() {
		return count;
	}
	
	public int capacity() {
		return elements.length;
	}
	
	private int inc(int i) {
		return (++i == elements.length) ? 0 : i;
	}
	
	private int inc(int i, int n) {
		return ((i += n) == elements.length) ? 0 : i;
	}

	private void put0(Object[] in, int offset, int length) throws InterruptedException {
		if (length > this.elements.length)
			throw new IllegalArgumentException();
		synchronized (lock) {
			// Wait until we have enough room
			while (count + length > this.elements.length)
				lock.wait();
			// Check for continuous chunk
			if (putIndex + length <= this.elements.length) {
				System.arraycopy(in, offset, this.elements, putIndex, length);
				putIndex = inc(putIndex, length);
			} else {
				int firstChunk = this.elements.length - putIndex;
				int remainChunk = length - firstChunk;
				System.arraycopy(in, offset, this.elements, putIndex, firstChunk);
				putIndex = 0;
				System.arraycopy(in, offset + firstChunk, this.elements, putIndex, remainChunk);
				putIndex = remainChunk;
			}
			count += length;
			lock.notifyAll();
		}
	}

	private int take0(Object[] out, int offset, int length) throws InterruptedException {
		if (length > this.elements.length)
			throw new IllegalArgumentException();
		synchronized (lock) {
			while (count == 0)
				lock.wait();
			int copySize = Math.min(this.count, length);
			if (takeIndex + copySize <= this.elements.length) {
				System.arraycopy(this.elements, takeIndex, out, offset, copySize);
				takeIndex = inc(takeIndex, copySize);
			} else {
				int firstChunk = this.elements.length - takeIndex;
				int remainChunk = copySize - firstChunk;
				System.arraycopy(this.elements, takeIndex, out, offset, firstChunk);
				takeIndex = 0;
				System.arraycopy(this.elements, takeIndex, out, offset + firstChunk, remainChunk);
				takeIndex = remainChunk;
			}
			count -= copySize;
			lock.notifyAll();
			return copySize;
		}
	}

}
