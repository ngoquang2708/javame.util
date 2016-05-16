package com.ngoquang2708.util;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BlockingOutputStream extends OutputStream {
	
	private final InternalInputStream iis;
	
	private final ByteBlockingQueue bbq;	

	public BlockingOutputStream() {
		this(ByteBlockingQueue.DEFAULT_CAPACITY);
	}
	
	public BlockingOutputStream(int bufferSize) {
		iis = new InternalInputStream();
		bbq = new ByteBlockingQueue(bufferSize);
	}

	public void write(int b) throws IOException {
		try {
			bbq.put(b);
		} catch (InterruptedException e) {
			throw new IOException(e.getMessage());
		}
	}
	
	public void write(byte[] b, int off, int len) throws IOException {	
		try {
			int capacity = bbq.capacity();
			if (len <= capacity) {
				bbq.put(b, off, len);
			} else {
				for (int i = 0; i < len; i += capacity)
					bbq.put(b, off + i, Math.min(capacity, len - i));
			}
		} catch (InterruptedException e) {
			throw new IOException(e.getMessage());
		}
	}
	
	public InputStream getInputStream() {
		return iis;
	}
	
	private class InternalInputStream extends InputStream {

		public int read() throws IOException {
			try {
				return bbq.take();
			} catch (InterruptedException e) {
				throw new IOException(e.getMessage());
			}
		}
		
		public int read(byte[] b, int off, int len) throws IOException {
			try {
				return bbq.take(b, off, Math.min(bbq.capacity(), len));
			} catch (InterruptedException e) {
				throw new IOException(e.getMessage());
			}
		}		
	}
}
