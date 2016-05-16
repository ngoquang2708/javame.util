package com.ngoquang2708.util.collection;

public abstract class AbstractCollection implements Collection {

	protected AbstractCollection() {
	}

	public abstract int size();

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean contains(Object o) {
		Iterator it = iterator();
		if (o == null) {
			while (it.hasNext())
				if (it.next() == null)
					return true;
		} else {
			while (it.hasNext())
				if (o.equals(it.next()))
					return true;
		}
		return false;
	}

	public abstract Iterator iterator();

	// FIXME size of collection is changed while calling this method
	public Object[] toArray() {
		Object[] r = new Object[size()];
		Iterator it = iterator();
		for (int i = 0; i < r.length; i++)
			r[i] = it.next();
		return r;
	}

	public boolean add(Object o) {
		throw new UnsupportedOperationException();
	}

	public boolean remove(Object o) {
		Iterator it = iterator();
		if (o == null) {
			while (it.hasNext()) {
				if (it.next() == null) {
					it.remove();
					return true;
				}
			}
		} else {
			while (it.hasNext()) {
				if (o.equals(it.next())) {
					it.remove();
					return true;
				}
			}
		}
		return false;
	}

	public boolean containsAll(Collection c) {
		for (Iterator i = c.iterator(); i.hasNext();)
			if (!contains(i.next()))
				return false;
		return true;
	}

	public boolean addAll(Collection c) {
		boolean modified = false;
		for (Iterator i = c.iterator(); i.hasNext();)
			if (add(i.next()))
				modified = true;
		return modified;
	}

	public boolean removeAll(Collection c) {
		boolean modified = false;
		Iterator it = iterator();
		while (it.hasNext()) {
			if (c.contains(it.next())) {
				it.remove();
				modified = true;
			}
		}
		return modified;
	}

	public boolean retainAll(Collection c) {
		boolean modified = false;
		Iterator it = iterator();
		while (it.hasNext()) {
			if (!c.contains(it.next())) {
				it.remove();
				modified = true;
			}
		}
		return modified;
	}

	public void clear() {
		Iterator it = iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
	}
}
