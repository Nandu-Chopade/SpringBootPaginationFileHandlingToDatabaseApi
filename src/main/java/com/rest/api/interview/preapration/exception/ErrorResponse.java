package com.rest.api.interview.preapration.exception;

import java.util.Date;

import lombok.Getter;

@Getter
public class ErrorResponse {

	 private int statusCode;
	 private String message;
	 private Date date;
	 
	public ErrorResponse(int status , String message, Date date) {
		super();
		this.message = message;
		this.statusCode = status;
		this.date = date;
	}
}
