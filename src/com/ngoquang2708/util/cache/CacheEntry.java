package com.ngoquang2708.util.cache;

public interface CacheEntry {

	long getPutTime();
	
	long getExpireTime();
	
	long getDuration();
	
	boolean isExpired();
	
	Object key();
	
	Object value();

}
