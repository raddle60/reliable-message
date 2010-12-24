/**
 * 
 */
package com.raddle.message.exception;

/**
 * @author xurong
 *
 */
public class ExistsMessageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ExistsMessageException() {
	}

	/**
	 * @param message
	 */
	public ExistsMessageException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ExistsMessageException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ExistsMessageException(String message, Throwable cause) {
		super(message, cause);
	}

}
