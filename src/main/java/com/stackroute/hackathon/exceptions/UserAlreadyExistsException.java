package com.stackroute.hackathon.exceptions;

 
public class UserAlreadyExistsException extends Exception{
	
	public UserAlreadyExistsException(String message) {
        super(message);
    }
}
