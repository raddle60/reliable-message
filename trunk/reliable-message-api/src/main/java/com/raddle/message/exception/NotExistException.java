/**
 * 
 */
package com.raddle.message.exception;

/**
 * @author xurong
 *
 */
public class NotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public NotExistException() {
	}

	/**
	 * @param message
	 */
	public NotExistException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NotExistException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotExistException(String message, Throwable cause) {
		super(message, cause);
	}

}
