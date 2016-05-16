package com.ngoquang2708.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.microedition.io.Connection;

public class IOs {

	private IOs() {
	}

	public static void close(InputStream is) {
		if (is == null)
			return;
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void close(OutputStream os) {
		if (os == null)
			return;
		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection c) {
		if (c == null)
			return;
		try {
			c.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void close(Reader r) {
		if (r == null)
			return;
		try {
			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void close(Writer w) {
		if (w == null)
			return;
		try {
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readInJarAsString(Class clazz, String file,
			String encoding) throws UnsupportedEncodingException {
		byte[] bytes = readInJarAsBytes(clazz, file);
		if (bytes == null)
			return null;
		return new String(bytes, encoding);
	}

	public static String readInJarAsString(Class clazz, String file) {
		String s = null;
		try {
			s = readInJarAsString(clazz, file, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

	public static byte[] readInJarAsBytes(Class clazz, String file) {
		InputStream is = openInJarInputStream(clazz, file);
		if (is == null)
			return null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int read;
			while ((read = is.read(buf)) != -1)
				baos.write(buf, 0, read);
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			close(is);
		}
	}

	public static InputStream openInJarInputStream(Class clazz, String name) {
		if (clazz == null)
			return IOs.class.getResourceAsStream("//" + name);
		return clazz.getResourceAsStream(name);
	}
}
