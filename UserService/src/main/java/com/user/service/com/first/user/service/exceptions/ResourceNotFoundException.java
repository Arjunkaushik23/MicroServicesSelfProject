package com.user.service.com.first.user.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Resource not found on server");
	}
	
	public ResourceNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
		
	}

}
