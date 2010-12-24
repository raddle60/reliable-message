/**
 * 
 */
package com.raddle.message.exception;

/**
 * @author xurong
 *
 */
public class MessageExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public MessageExistsException() {
	}

	/**
	 * @param message
	 */
	public MessageExistsException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public MessageExistsException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MessageExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
