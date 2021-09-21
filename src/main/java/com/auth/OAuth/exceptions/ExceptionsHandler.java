package com.auth.OAuth.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
	
	private Logger logger = LoggerFactory.getLogger(ExceptionsHandler.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> throwException(Exception e){
		logger.info("ExceptionsHandler.throwException: {} ", e.getMessage());
		return new ResponseEntity<String>("Please give valid API request",HttpStatus.BAD_REQUEST);
	}

}
