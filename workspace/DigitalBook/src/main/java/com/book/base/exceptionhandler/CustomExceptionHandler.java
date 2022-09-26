package com.book.base.exceptionhandler;

public class CustomExceptionHandler {

	public static class InvalidAuthorNameException extends RuntimeException {

		public InvalidAuthorNameException(String message) {
			super(message);
		}
	}

	public static class InvalidBookException extends RuntimeException {

		public InvalidBookException(String message) {
			super(message);
		}
	}

	public static class UserNotFoundException extends RuntimeException {

		public UserNotFoundException(String message) {
			super(message);
		}
	}

}
