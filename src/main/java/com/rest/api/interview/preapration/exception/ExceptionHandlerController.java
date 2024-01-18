package com.rest.api.interview.preapration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = InvalidFileSizeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> invalidSizeFileException(InvalidFileSizeException ex) {
        ErrorResponse error = new ErrorResponse(400, "File size too large", new Date());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
