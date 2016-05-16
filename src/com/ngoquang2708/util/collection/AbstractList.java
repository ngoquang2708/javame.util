package com.ngoquang2708.util.collection;

public abstract class AbstractList extends AbstractCollection implements List {

	protected AbstractList() {
	}

	public abstract Object get(int i);

	public Object set(int i, Object o) {
		throw new UnsupportedOperationException();
	}

	public void add(int i, Object o) {
		throw new UnsupportedOperationException();
	}

	public Object remove(int i) {
		throw new UnsupportedOperationException();
	}

	public int indexOf(Object o) {
		ListIterator it = listIterator();
		if (o == null) {
			while (it.hasNext())
				if (it.next() == null)
					return it.previousIndex();
		} else {
			while (it.hasNext())
				if (o.equals(it.next()))
					return it.previousIndex();
		}
		return -1;
	}

	public int lastIndexOf(Object o) {
		ListIterator it = listIterator(size());
		if (o == null) {
			while (it.hasPrevious())
				if (it.previous() == null)
					return it.nextIndex();
		} else {
			while (it.hasPrevious())
				if (o.equals(it.previous()))
					return it.nextIndex();
		}
		return -1;
	}

	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator listIterator(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(Object o) {
		add(size(), o);
		return true;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int i, Collection c) {
		rangeCheckForAdd(i);
		boolean modified = false;
		for (Iterator it = c.iterator(); it.hasNext();) {
			add(i++, it.next());
			modified = true;
		}
		return modified;
	}

	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		removeRange(0, size());
	}

	protected void removeRange(int fromIndex, int toIndex) {
		ListIterator it = listIterator(fromIndex);
		for (int i = 0, n = toIndex - fromIndex; i < n; i++) {
			it.next();
			it.remove();
		}
	}

	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size();
	}
}
