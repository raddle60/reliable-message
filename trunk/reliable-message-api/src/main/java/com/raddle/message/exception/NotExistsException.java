/**
 * 
 */
package com.raddle.message.exception;

/**
 * @author xurong
 *
 */
public class NotExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public NotExistsException() {
	}

	/**
	 * @param message
	 */
	public NotExistsException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NotExistsException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
