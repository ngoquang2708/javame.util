package com.ngoquang2708.util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class BlockingOutputStreamConsumer {
	
	private final BlockingOutputStream bos;
	
	private final OutputStream os;
	
	private final Object lock;
	
	private volatile boolean isRunning;

	public BlockingOutputStreamConsumer(
			BlockingOutputStream bos, OutputStream os) {
		this.bos = bos;
		this.os = os;
		this.lock = new Object();
		this.isRunning = false;
	}
	
	public void start() {
		if (!isRunning) {
			synchronized (lock) {
				if (!isRunning) {
					Thread t = new Thread(new BlockingOutputStreamConsumerThread());
					t.start();
				}
			}
		} else {
			throw new IllegalStateException("started");
		}
	}
	
	public void stop() {
		// TODO
	}
	
	private class BlockingOutputStreamConsumerThread implements Runnable {
		
		public void run() {
			InputStream is = bos.getInputStream();
			try {
				byte[] buf = new byte[3];
				int read;
				while ((read = is.read(buf)) != -1) {
					os.write(buf, 0, read);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}
