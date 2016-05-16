package com.ngoquang2708.util.cache;

public interface Cache {
	
	boolean containsKey(Object key);
	
	boolean containsValue(Object value);

	Object get(Object key);
	
	Object put(Object key, Object value);

	boolean putIfAbsent(Object key, Object value);

	Object putWithExpire(Object key, Object value, long duration);

}
