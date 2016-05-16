package com.ngoquang2708.util.cache;

public class Caches {

	public static Cache newCache() {
		return new HashtableCache();
	}
}
