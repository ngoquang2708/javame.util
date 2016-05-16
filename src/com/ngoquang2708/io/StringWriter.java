/*
 * Copyright (c) 1996, 2004, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.ngoquang2708.io;

import java.io.IOException;
import java.io.Writer;

/**
 * A character stream that collects its output in a string buffer, which can
 * then be used to construct a string.
 * <p>
 * Closing a <tt>StringWriter</tt> has no effect. The methods in this class
 * can be called after the stream has been closed without generating an
 * <tt>IOException</tt>.
 *
 * @author      Mark Reinhold
 * @since       JDK1.1
 */
public class StringWriter extends Writer {

	private StringBuffer buf;

	/**
	 * Create a new string writer using the default initial string-buffer
	 * size.
	 */
	public StringWriter() {
		buf = new StringBuffer();
		lock = buf;
	}

	/**
	 * Create a new string writer using the specified initial string-buffer
	 * size.
	 *
	 * @param initialSize
	 *        The number of <tt>char</tt> values that will fit into this buffer
	 *        before it is automatically expanded
	 *
	 * @throws IllegalArgumentException
	 *         If <tt>initialSize</tt> is negative
	 */
	public StringWriter(int initialSize) {
		if (initialSize < 0) {
			throw new IllegalArgumentException("Negative buffer size");
		}
		buf = new StringBuffer(initialSize);
		lock = buf;
	}

	/**
	 * Write a single character.
	 */
	public void write(int c) {
		buf.append((char) c);
	}

	/**
	 * Write a portion of an array of characters.
	 *
	 * @param  cbuf  Array of characters
	 * @param  off   Offset from which to start writing characters
	 * @param  len   Number of characters to write
	 */
	public void write(char cbuf[], int off, int len) {
		if ((off < 0) || (off > cbuf.length) || (len < 0)
				|| ((off + len) > cbuf.length) || ((off + len) < 0)) {
			throw new IndexOutOfBoundsException();
		} else if (len == 0) {
			return;
		}
		buf.append(cbuf, off, len);
	}

	/**
	 * Write a string.
	 */
	public void write(String str) {
		buf.append(str);
	}

	/**
	 * Write a portion of a string.
	 *
	 * @param  str  String to be written
	 * @param  off  Offset from which to start writing characters
	 * @param  len  Number of characters to write
	 */
	public void write(String str, int off, int len) {
		buf.append(str.substring(off, off + len));
	}

	/**
	 * Appends the specified character to this writer.
	 *
	 * <p> An invocation of this method of the form <tt>out.append(c)</tt>
	 * behaves in exactly the same way as the invocation
	 *
	 * <pre>
	 *     out.write(c) </pre>
	 *
	 * @param  c
	 *         The 16-bit character to append
	 *
	 * @return  This writer
	 *
	 * @since 1.5
	 */
	public StringWriter append(char c) {
		write(c);
		return this;
	}

	/**
	 * Return the buffer's current value as a string.
	 */
	public String toString() {
		return buf.toString();
	}

	/**
	 * Return the string buffer itself.
	 *
	 * @return StringBuffer holding the current buffer value.
	 */
	public StringBuffer getBuffer() {
		return buf;
	}

	/**
	 * Flush the stream.
	 */
	public void flush() {
	}

	/**
	 * Closing a <tt>StringWriter</tt> has no effect. The methods in this
	 * class can be called after the stream has been closed without generating
	 * an <tt>IOException</tt>.
	 */
	public void close() throws IOException {
	}
}
