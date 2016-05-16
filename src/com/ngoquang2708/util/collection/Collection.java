package com.ngoquang2708.util.collection;

public interface Collection extends Iterable {

	int size();
	boolean isEmpty();
	boolean contains(Object o);
	Iterator iterator();
	Object[] toArray();
	boolean add(Object o);
	boolean remove(Object o);
	boolean containsAll(Collection c);
	boolean addAll(Collection c);
	boolean removeAll(Collection c);
	boolean retainAll(Collection c);
	void clear();
	boolean equals(Object o);
	int hashCode();
}
