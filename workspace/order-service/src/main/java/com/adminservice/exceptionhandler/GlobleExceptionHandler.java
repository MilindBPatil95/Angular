package com.adminservice.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {
	
	@ExceptionHandler
	public String invalid(CustomExceptionHandler.InvalidUserException e) {
		return e.getMessage();

	}
	
	
	
	

}
