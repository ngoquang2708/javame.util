package com.ngoquang2708.util;

import java.io.IOException;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;

import com.ngoquang2708.io.BufferedReader;
import com.ngoquang2708.io.StringReader;

public class Properties {
	
	private static final String lineSeparator = "\n"; // XXX System.getProperty("line.separator");

	protected Hashtable properties;

	public Properties() {
		properties = new Hashtable();
	}

	public Properties(String source) throws IOException {
		this(new StringReader(source));
	}

	public Properties(Reader reader) throws IOException {
		properties = new Hashtable();

		BufferedReader br = new BufferedReader(reader);
		String line;
		try {
			final String DELIM = ": ";
			final int DELIM_LENGTH = DELIM.length();
			while ((line = br.readLine()) != null) {
				int found = line.indexOf(DELIM);
				if (found == -1) {
					throw new RuntimeException();
				} else {
					String key = line.substring(0, found);
					String value = line.substring(found + DELIM_LENGTH);
					properties.put(key, value);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOs.close(reader);
		}
	}

	public void put(String key, String value) {
		properties.put(key, value);
	}

	public String get(String key) {
		return (String) properties.get(key);
	}

	public Enumeration keys() {
		return properties.keys();
	}

	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		Enumeration keys = properties.keys();
		Enumeration values = properties.elements();
		while (keys.hasMoreElements()) {
			stringBuffer.append((String) keys.nextElement());
			stringBuffer.append(": ");
			stringBuffer.append((String) values.nextElement());
			stringBuffer.append(lineSeparator);
		}
		return stringBuffer.toString();
	}
}
