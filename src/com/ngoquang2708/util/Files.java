package com.ngoquang2708.util;

import java.util.Enumeration;

import javax.microedition.io.file.FileSystemRegistry;

public class Files {
	
	public static final String fileSeparator = "/"; // XXX System.getProperty("file.separator");

	public static String getParent(String path) {
		String result = null;
		int fileSeparatorLength = 1; // XXX fileSeparator.length();
		if (path.endsWith(fileSeparator))
			path = path.substring(0, path.length() - fileSeparatorLength);

		int index = path.lastIndexOf(/* XXX fileSeparator */ fileSeparator.charAt(0));
		if (index != -1) {
			String parent = path.substring(0, index + 1);
			if (!parent.equals("file://"))
				result = parent;
		}
		return result;
	}
	
	public static boolean isRoot(String path) {
		Enumeration roots = FileSystemRegistry.listRoots();
		boolean result = false;
		while (roots.hasMoreElements()) {
			String root = (String) roots.nextElement();
			if (root.equals(path)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	public static boolean isMegaRoot(String path) {
		return path.equals("file:///"); // TODO
	}
	
	public static boolean isDirectory(String path) {
		return path.endsWith(fileSeparator);
	}
	
	public static String getCurrentDirectory(String path) {
		String result = null;
		int fileSeparatorLength = 1; // XXX fileSeparator.length();
		if (path.endsWith(fileSeparator)) {
			path = path.substring(0, path.length() - fileSeparatorLength);
			int index = path.lastIndexOf(/* XXX fileSeparator */ fileSeparator.charAt(0));
			if (index == -1)
				result = path + fileSeparator;
			else
				result = path.substring(index + fileSeparatorLength) + fileSeparator;
		}
		return result;
	}
}
