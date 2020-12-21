package com.eden.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class EntityNotFoundException.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Could not find entity with id.")
public class EntityNotFoundException extends Exception {

	/** The Constant serialVersionUID. */
	static final long serialVersionUID = -3387516993334229948L;

	/**
	 * Instantiates a new entity not found exception.
	 *
	 * @param message
	 *            the message
	 */
	public EntityNotFoundException(String message) {
		super(message);
	}

}
