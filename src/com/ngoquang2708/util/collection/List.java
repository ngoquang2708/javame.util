package com.ngoquang2708.util.collection;

public interface List extends Collection {

	Object get(int i);
	Object set(int i, Object o);
	void add(int i, Object o);
	boolean addAll(int i, Collection c);
	Object remove(int i);
	int indexOf(Object o);
	int lastIndexOf(Object o);
	List subList(int fromIndex, int toIndex);
	ListIterator listIterator();
	ListIterator listIterator(int i);
}
