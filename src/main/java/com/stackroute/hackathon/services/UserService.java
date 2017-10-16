package com.stackroute.hackathon.services;


import com.stackroute.hackathon.domain.User;
import com.stackroute.hackathon.exceptions.UserAlreadyExistsException;
import com.stackroute.hackathon.exceptions.UserNotFoundException;

//Interface for all the services

public interface UserService {
	public User getUserById(int id) throws UserNotFoundException;
	public User getUserByName(String name)  throws UserNotFoundException;
	public String deleteUser(User user) throws UserNotFoundException;
	public String deleteUserById(int id)  throws UserNotFoundException;
	public String deleteUserByName(String name)  throws UserNotFoundException;
	public Iterable<User> getAllUsers();
	public String saveUser(User user)  throws UserAlreadyExistsException;
	public String updateUser(User user)  throws UserNotFoundException;
}
