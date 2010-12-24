/**
 * 
 */
package com.raddle.message.exception;

/**
 * @author xurong
 *
 */
public class AlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public AlreadyExistsException() {
	}

	/**
	 * @param message
	 */
	public AlreadyExistsException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AlreadyExistsException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
