package com.book.base.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.book.base.utility.Message;
import com.book.base.utility.Response;

@RestControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(CustomExceptionHandler.InvalidBookException.class)
	public Response invalidBookException(CustomExceptionHandler.InvalidBookException e) {
		return new Response(Message.OK, e.getMessage());

	}
	
   @ExceptionHandler(CustomExceptionHandler.InvalidAuthorNameException.class)
   
   public Response invalidAuthorNameException(CustomExceptionHandler.InvalidAuthorNameException e) {
	   
	   return new Response(Message.OK, e.getMessage());
   }
}
