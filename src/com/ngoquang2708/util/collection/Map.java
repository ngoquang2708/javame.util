package com.ngoquang2708.util.collection;

public interface Map {

	int size();
	boolean isEmpty();
	boolean containsKey(Object key);
	boolean containsValue(Object value);
	Object get(Object key);
	Object put(Object key, Object value);
	Object remove(Object key);
	void putAll(Map m);
	void clear();
	Set keySet();
	Collection values();
	Set entrySet();

	interface Entry {
		Object getKey();
		Object getValue();
		Object setValue(Object value);
		boolean equals(Object o);
		int hashCode();
	}
}
