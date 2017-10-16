package com.stackroute.hackathon.services;


import com.stackroute.hackathon.domain.User;

//Interface for all the services

public interface UserService {
	public User getUserById(int id);
	public User getUserByName(String name);
	public String deleteUser(User user);
	public String deleteUserById(int id);
	public String deleteUserByName(String name);
	public Iterable<User> getAllUsers();
	public String saveUser(User user); 
}
