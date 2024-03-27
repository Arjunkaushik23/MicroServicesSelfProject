package com.hotel.service.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	
	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Resouce not found here !!");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
