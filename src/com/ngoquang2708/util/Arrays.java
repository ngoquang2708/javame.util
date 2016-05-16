package com.ngoquang2708.util;

public class Arrays {

	private Arrays() {
	}

	public static void sort(byte[] a) {
		sort0(a, 0, a.length - 1);
	}

	public static void sort(byte[] a, int fromIndex, int toIndex) {
		rangeCheck(a.length, fromIndex, toIndex);
		sort0(a, fromIndex, toIndex - 1);
	}

	private static void sort0(byte[] a, int start, int end) {
		if (start < end) {
			byte pivotVal = a[(start + end) >> 1];
			int left = start;
			int right = end;
			while (left <= right) {
				while (a[left] < pivotVal)
					left++;
				while (a[right] > pivotVal)
					right--;
				if (left <= right) {
					byte temp = a[left];
					a[left] = a[right];
					a[right] = temp;
					left++;
					right--;
				}
			}
			if (start < right)
				sort0(a, start, right);
			if (end > left)
				sort0(a, left, end);
		}
	}

	public static void sort(short[] a) {
		sort0(a, 0, a.length - 1);
	}

	public static void sort(short[] a, int fromIndex, int toIndex) {
		rangeCheck(a.length, fromIndex, toIndex);
		sort0(a, fromIndex, toIndex - 1);
	}

	private static void sort0(short[] a, int start, int end) {
		if (start < end) {
			short pivotVal = a[(start + end) >> 1];
			int left = start;
			int right = end;
			while (left <= right) {
				while (a[left] < pivotVal)
					left++;
				while (a[right] > pivotVal)
					right--;
				if (left <= right) {
					short temp = a[left];
					a[left] = a[right];
					a[right] = temp;
					left++;
					right--;
				}
			}
			if (start < right)
				sort0(a, start, right);
			if (end > left)
				sort0(a, left, end);
		}
	}

	public static void sort(char[] a) {
		sort0(a, 0, a.length - 1);
	}

	public static void sort(char[] a, int fromIndex, int toIndex) {
		rangeCheck(a.length, fromIndex, toIndex);
		sort0(a, fromIndex, toIndex - 1);
	}

	private static void sort0(char[] a, int start, int end) {
		if (start < end) {
			char pivotVal = a[(start + end) >> 1];
			int left = start;
			int right = end;
			while (left <= right) {
				while (a[left] < pivotVal)
					left++;
				while (a[right] > pivotVal)
					right--;
				if (left <= right) {
					char temp = a[left];
					a[left] = a[right];
					a[right] = temp;
					left++;
					right--;
				}
			}
			if (start < right)
				sort0(a, start, right);
			if (end > left)
				sort0(a, left, end);
		}
	}

	public static void sort(int[] a) {
		sort0(a, 0, a.length - 1);
	}

	public static void sort(int[] a, int fromIndex, int toIndex) {
		rangeCheck(a.length, fromIndex, toIndex);
		sort0(a, fromIndex, toIndex - 1);
	}

	private static void sort0(int[] a, int start, int end) {
		if (start < end) {
			int pivotVal = a[(start + end) >> 1];
			int left = start;
			int right = end;
			while (left <= right) {
				while (a[left] < pivotVal)
					left++;
				while (a[right] > pivotVal)
					right--;
				if (left <= right) {
					int temp = a[left];
					a[left] = a[right];
					a[right] = temp;
					left++;
					right--;
				}
			}
			if (start < right)
				sort0(a, start, right);
			if (end > left)
				sort0(a, left, end);
		}
	}

	public static void sort(long[] a) {
		sort0(a, 0, a.length - 1);
	}

	public static void sort(long[] a, int fromIndex, int toIndex) {
		rangeCheck(a.length, fromIndex, toIndex);
		sort0(a, fromIndex, toIndex - 1);
	}

	private static void sort0(long[] a, int start, int end) {
		if (start < end) {
			long pivotVal = a[(start + end) >> 1];
			int left = start;
			int right = end;
			while (left <= right) {
				while (a[left] < pivotVal)
					left++;
				while (a[right] > pivotVal)
					right--;
				if (left <= right) {
					long temp = a[left];
					a[left] = a[right];
					a[right] = temp;
					left++;
					right--;
				}
			}
			if (start < right)
				sort0(a, start, right);
			if (end > left)
				sort0(a, left, end);
		}
	}

	public static int binarySearch(long[] a, long key) {
		return binarySearch0(a, 0, a.length, key);
	}

	public static int binarySearch(long[] a, int fromIndex, int toIndex,
			long key) {
		rangeCheck(a.length, fromIndex, toIndex);
		return binarySearch0(a, fromIndex, toIndex, key);
	}

	private static int binarySearch0(long[] a, int fromIndex, int toIndex,
			long key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >> 1;
			long midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

	public static int binarySearch(int[] a, int key) {
		return binarySearch0(a, 0, a.length, key);
	}

	public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
		rangeCheck(a.length, fromIndex, toIndex);
		return binarySearch0(a, fromIndex, toIndex, key);
	}

	private static int binarySearch0(int[] a, int fromIndex, int toIndex,
			int key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >> 1;
			int midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

	public static int binarySearch(short[] a, short key) {
		return binarySearch0(a, 0, a.length, key);
	}

	public static int binarySearch(short[] a, int fromIndex, int toIndex,
			short key) {
		rangeCheck(a.length, fromIndex, toIndex);
		return binarySearch0(a, fromIndex, toIndex, key);
	}

	private static int binarySearch0(short[] a, int fromIndex, int toIndex,
			short key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >> 1;
			short midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

	public static int binarySearch(char[] a, char key) {
		return binarySearch0(a, 0, a.length, key);
	}

	public static int binarySearch(char[] a, int fromIndex, int toIndex,
			char key) {
		rangeCheck(a.length, fromIndex, toIndex);
		return binarySearch0(a, fromIndex, toIndex, key);
	}

	private static int binarySearch0(char[] a, int fromIndex, int toIndex,
			char key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >> 1;
			char midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

	public static int binarySearch(byte[] a, byte key) {
		return binarySearch0(a, 0, a.length, key);
	}

	public static int binarySearch(byte[] a, int fromIndex, int toIndex,
			byte key) {
		rangeCheck(a.length, fromIndex, toIndex);
		return binarySearch0(a, fromIndex, toIndex, key);
	}

	private static int binarySearch0(byte[] a, int fromIndex, int toIndex,
			byte key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >> 1;
			byte midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

	public static boolean equals(long[] a, long[] a2) {
		if (a == a2)
			return true;
		if (a == null || a2 == null)
			return false;

		int length = a.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++)
			if (a[i] != a2[i])
				return false;

		return true;
	}

	public static boolean equals(int[] a, int[] a2) {
		if (a == a2)
			return true;
		if (a == null || a2 == null)
			return false;

		int length = a.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++)
			if (a[i] != a2[i])
				return false;

		return true;
	}

	public static boolean equals(short[] a, short a2[]) {
		if (a == a2)
			return true;
		if (a == null || a2 == null)
			return false;

		int length = a.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++)
			if (a[i] != a2[i])
				return false;

		return true;
	}

	public static boolean equals(char[] a, char[] a2) {
		if (a == a2)
			return true;
		if (a == null || a2 == null)
			return false;

		int length = a.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++)
			if (a[i] != a2[i])
				return false;

		return true;
	}

	public static boolean equals(byte[] a, byte[] a2) {
		if (a == a2)
			return true;
		if (a == null || a2 == null)
			return false;

		int length = a.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++)
			if (a[i] != a2[i])
				return false;

		return true;
	}

	public static boolean equals(boolean[] a, boolean[] a2) {
		if (a == a2)
			return true;
		if (a == null || a2 == null)
			return false;

		int length = a.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++)
			if (a[i] != a2[i])
				return false;

		return true;
	}

	public static boolean equals(double[] a, double[] a2) {
		if (a == a2)
			return true;
		if (a == null || a2 == null)
			return false;

		int length = a.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++)
			if (Double.doubleToLongBits(a[i]) != Double.doubleToLongBits(a2[i]))
				return false;

		return true;
	}

	public static boolean equals(float[] a, float[] a2) {
		if (a == a2)
			return true;
		if (a == null || a2 == null)
			return false;

		int length = a.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++)
			if (Float.floatToIntBits(a[i]) != Float.floatToIntBits(a2[i]))
				return false;

		return true;
	}

	public static boolean equals(Object[] a, Object[] a2) {
		if (a == a2)
			return true;
		if (a == null || a2 == null)
			return false;

		int length = a.length;
		if (a2.length != length)
			return false;

		for (int i = 0; i < length; i++) {
			Object o1 = a[i];
			Object o2 = a2[i];
			if (!(o1 == null ? o2 == null : o1.equals(o2)))
				return false;
		}

		return true;
	}

	public static void fill(long[] a, long val) {
		for (int i = 0, len = a.length; i < len; i++)
			a[i] = val;
	}

	public static void fill(long[] a, int fromIndex, int toIndex, long val) {
		rangeCheck(a.length, fromIndex, toIndex);
		for (int i = fromIndex; i < toIndex; i++)
			a[i] = val;
	}

	public static void fill(int[] a, int val) {
		for (int i = 0, len = a.length; i < len; i++)
			a[i] = val;
	}

	public static void fill(int[] a, int fromIndex, int toIndex, int val) {
		rangeCheck(a.length, fromIndex, toIndex);
		for (int i = fromIndex; i < toIndex; i++)
			a[i] = val;
	}

	public static void fill(short[] a, short val) {
		for (int i = 0, len = a.length; i < len; i++)
			a[i] = val;
	}

	public static void fill(short[] a, int fromIndex, int toIndex, short val) {
		rangeCheck(a.length, fromIndex, toIndex);
		for (int i = fromIndex; i < toIndex; i++)
			a[i] = val;
	}

	public static void fill(char[] a, char val) {
		for (int i = 0, len = a.length; i < len; i++)
			a[i] = val;
	}

	public static void fill(char[] a, int fromIndex, int toIndex, char val) {
		rangeCheck(a.length, fromIndex, toIndex);
		for (int i = fromIndex; i < toIndex; i++)
			a[i] = val;
	}

	public static void fill(byte[] a, byte val) {
		for (int i = 0, len = a.length; i < len; i++)
			a[i] = val;
	}

	public static void fill(byte[] a, int fromIndex, int toIndex, byte val) {
		rangeCheck(a.length, fromIndex, toIndex);
		for (int i = fromIndex; i < toIndex; i++)
			a[i] = val;
	}

	public static void fill(boolean[] a, boolean val) {
		for (int i = 0, len = a.length; i < len; i++)
			a[i] = val;
	}

	public static void fill(boolean[] a, int fromIndex, int toIndex, boolean val) {
		rangeCheck(a.length, fromIndex, toIndex);
		for (int i = fromIndex; i < toIndex; i++)
			a[i] = val;
	}

	public static void fill(double[] a, double val) {
		for (int i = 0, len = a.length; i < len; i++)
			a[i] = val;
	}

	public static void fill(double[] a, int fromIndex, int toIndex, double val) {
		rangeCheck(a.length, fromIndex, toIndex);
		for (int i = fromIndex; i < toIndex; i++)
			a[i] = val;
	}

	public static void fill(float[] a, float val) {
		for (int i = 0, len = a.length; i < len; i++)
			a[i] = val;
	}

	public static void fill(float[] a, int fromIndex, int toIndex, float val) {
		rangeCheck(a.length, fromIndex, toIndex);
		for (int i = fromIndex; i < toIndex; i++)
			a[i] = val;
	}

	public static void fill(Object[] a, Object val) {
		for (int i = 0, len = a.length; i < len; i++)
			a[i] = val;
	}

	public static void fill(Object[] a, int fromIndex, int toIndex, Object val) {
		rangeCheck(a.length, fromIndex, toIndex);
		for (int i = fromIndex; i < toIndex; i++)
			a[i] = val;
	}

	public static byte[] copyOf(byte[] original, int newLength) {
		byte[] copy = new byte[newLength];
		System.arraycopy(original, 0, copy, 0,
				Math.min(original.length, newLength));
		return copy;
	}

	public static short[] copyOf(short[] original, int newLength) {
		short[] copy = new short[newLength];
		System.arraycopy(original, 0, copy, 0,
				Math.min(original.length, newLength));
		return copy;
	}

	public static int[] copyOf(int[] original, int newLength) {
		int[] copy = new int[newLength];
		System.arraycopy(original, 0, copy, 0,
				Math.min(original.length, newLength));
		return copy;
	}

	public static long[] copyOf(long[] original, int newLength) {
		long[] copy = new long[newLength];
		System.arraycopy(original, 0, copy, 0,
				Math.min(original.length, newLength));
		return copy;
	}

	public static char[] copyOf(char[] original, int newLength) {
		char[] copy = new char[newLength];
		System.arraycopy(original, 0, copy, 0,
				Math.min(original.length, newLength));
		return copy;
	}

	public static float[] copyOf(float[] original, int newLength) {
		float[] copy = new float[newLength];
		System.arraycopy(original, 0, copy, 0,
				Math.min(original.length, newLength));
		return copy;
	}

	public static double[] copyOf(double[] original, int newLength) {
		double[] copy = new double[newLength];
		System.arraycopy(original, 0, copy, 0,
				Math.min(original.length, newLength));
		return copy;
	}

	public static boolean[] copyOf(boolean[] original, int newLength) {
		boolean[] copy = new boolean[newLength];
		System.arraycopy(original, 0, copy, 0,
				Math.min(original.length, newLength));
		return copy;
	}

	public static byte[] copyOfRange(byte[] original, int from, int to) {
		int newLength = to - from;
		if (newLength < 0)
			throw new IllegalArgumentException(from + " > " + to);
		byte[] copy = new byte[newLength];
		System.arraycopy(original, from, copy, 0,
				Math.min(original.length - from, newLength));
		return copy;
	}

	public static short[] copyOfRange(short[] original, int from, int to) {
		int newLength = to - from;
		if (newLength < 0)
			throw new IllegalArgumentException(from + " > " + to);
		short[] copy = new short[newLength];
		System.arraycopy(original, from, copy, 0,
				Math.min(original.length - from, newLength));
		return copy;
	}

	public static int[] copyOfRange(int[] original, int from, int to) {
		int newLength = to - from;
		if (newLength < 0)
			throw new IllegalArgumentException(from + " > " + to);
		int[] copy = new int[newLength];
		System.arraycopy(original, from, copy, 0,
				Math.min(original.length - from, newLength));
		return copy;
	}

	public static long[] copyOfRange(long[] original, int from, int to) {
		int newLength = to - from;
		if (newLength < 0)
			throw new IllegalArgumentException(from + " > " + to);
		long[] copy = new long[newLength];
		System.arraycopy(original, from, copy, 0,
				Math.min(original.length - from, newLength));
		return copy;
	}

	public static char[] copyOfRange(char[] original, int from, int to) {
		int newLength = to - from;
		if (newLength < 0)
			throw new IllegalArgumentException(from + " > " + to);
		char[] copy = new char[newLength];
		System.arraycopy(original, from, copy, 0,
				Math.min(original.length - from, newLength));
		return copy;
	}

	public static float[] copyOfRange(float[] original, int from, int to) {
		int newLength = to - from;
		if (newLength < 0)
			throw new IllegalArgumentException(from + " > " + to);
		float[] copy = new float[newLength];
		System.arraycopy(original, from, copy, 0,
				Math.min(original.length - from, newLength));
		return copy;
	}

	public static double[] copyOfRange(double[] original, int from, int to) {
		int newLength = to - from;
		if (newLength < 0)
			throw new IllegalArgumentException(from + " > " + to);
		double[] copy = new double[newLength];
		System.arraycopy(original, from, copy, 0,
				Math.min(original.length - from, newLength));
		return copy;
	}

	public static boolean[] copyOfRange(boolean[] original, int from, int to) {
		int newLength = to - from;
		if (newLength < 0)
			throw new IllegalArgumentException(from + " > " + to);
		boolean[] copy = new boolean[newLength];
		System.arraycopy(original, from, copy, 0,
				Math.min(original.length - from, newLength));
		return copy;
	}

	public static String toString(long[] a) {
		if (a == null)
			return "null";
		int iMax = a.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuffer b = new StringBuffer();
		b.append('[');
		for (int i = 0;; i++) {
			b.append(a[i]);
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}

	public static String toString(int[] a) {
		if (a == null)
			return "null";
		int iMax = a.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuffer b = new StringBuffer();
		b.append('[');
		for (int i = 0;; i++) {
			b.append(a[i]);
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}

	public static String toString(short[] a) {
		if (a == null)
			return "null";
		int iMax = a.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuffer b = new StringBuffer();
		b.append('[');
		for (int i = 0;; i++) {
			b.append(a[i]);
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}

	public static String toString(char[] a) {
		if (a == null)
			return "null";
		int iMax = a.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuffer b = new StringBuffer();
		b.append('[');
		for (int i = 0;; i++) {
			b.append(a[i]);
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}

	public static String toString(byte[] a) {
		if (a == null)
			return "null";
		int iMax = a.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuffer b = new StringBuffer();
		b.append('[');
		for (int i = 0;; i++) {
			b.append(a[i]);
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}

	public static String toString(boolean[] a) {
		if (a == null)
			return "null";
		int iMax = a.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuffer b = new StringBuffer();
		b.append('[');
		for (int i = 0;; i++) {
			b.append(a[i]);
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}

	public static String toString(float[] a) {
		if (a == null)
			return "null";

		int iMax = a.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuffer b = new StringBuffer();
		b.append('[');
		for (int i = 0;; i++) {
			b.append(a[i]);
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}

	public static String toString(double[] a) {
		if (a == null)
			return "null";
		int iMax = a.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuffer b = new StringBuffer();
		b.append('[');
		for (int i = 0;; i++) {
			b.append(a[i]);
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}

	public static String toString(Object[] a) {
		if (a == null)
			return "null";

		int iMax = a.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuffer b = new StringBuffer();
		b.append('[');
		for (int i = 0;; i++) {
			b.append(String.valueOf(a[i]));
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}

	private static void rangeCheck(int length, int fromIndex, int toIndex) {
		if (fromIndex > toIndex) {
			throw new IllegalArgumentException("fromIndex(" + fromIndex
					+ ") > toIndex(" + toIndex + ")");
		}
		if (fromIndex < 0) {
			throw new ArrayIndexOutOfBoundsException(fromIndex);
		}
		if (toIndex > length) {
			throw new ArrayIndexOutOfBoundsException(toIndex);
		}
	}
}