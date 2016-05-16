package com.ngoquang2708.util.cache;

import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;

public class HashtableCache implements Cache {
	
	protected final Hashtable cache = new Hashtable();
	
	protected final Timer gcTimer = new Timer();

	public Object get(Object key) {
		return cache.get(key);
	}

	public Object put(Object key, Object value) {
		return cache.put(key, value);
	}

	public boolean putIfAbsent(Object key, Object value) {
		if (!cache.contains(key)) {
			synchronized (cache) {
				if (!cache.contains(key)) {
					cache.put(key, value);
					return true;
				}
			}
		}
		return false;
	}

	public boolean containsKey(Object key) {
		return cache.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return cache.contains(value);
	}

	public Object putWithExpire(final Object key, final Object value, final long duration) {
		Object result;
		if ((result = cache.get(key)) == null) {
			synchronized (cache) {
				if ((result = cache.get(key)) == null) {
					cache.put(key, value);
					gcTimer.schedule(new TimerTask() {
						
						public void run() {
							System.out.println("remove expired entry: " + value);
							cache.remove(key);
						}
					}, duration);
				}
			}
		}
		return result;
	}
}