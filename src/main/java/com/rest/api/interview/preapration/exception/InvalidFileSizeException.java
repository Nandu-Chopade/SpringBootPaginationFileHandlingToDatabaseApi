package com.rest.api.interview.preapration.exception;

import lombok.Getter;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST , reason="File size must be less than 5 MB or equels to 5 MB")
@Getter
public class InvalidFileSizeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  
	public InvalidFileSizeException(String message) {
		super(message);
	}
	
	
}
