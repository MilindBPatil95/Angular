package com.adminservice.exceptionhandler;

public class CustomExceptionHandler {

	public static class InvalidUserException extends RuntimeException {
		 
		 public InvalidUserException(String message) {
			 
			 super(message);
			
		}

	}

    public static class UserNotFoundException extends RuntimeException{
    	
    	public UserNotFoundException(String message) {
			super(message);
		}
    }

	

}
