package com.stackroute.hackathon.services;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.stackroute.hackathon.domain.User;
import com.stackroute.hackathon.repositories.UserRepository;


//Service implementation
@Service 
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	//<--- Setter-Getter Methods ---> 
	public UserRepository getMovieRepository() {
		return userRepository;
	}

	public void setMovieRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	//<--- Get Methods ---> 
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub 
		return userRepository.findOne(id); 
	} 
	
	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//<--- Delete Methods ---> 
	@Override
	public String deleteUser(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
		return "User deleted successfully";
	}

	@Override
	public String deleteUserById(int id) {
		// TODO Auto-generated method stub
		User user = getUserById(id);
		userRepository.delete(id);
		return "User deleted successfully";
	}

	@Override
	public String deleteUserByName(String name) {
		// TODO Auto-generated method stub
		User user = getUserByName(name);
		userRepository.delete(user);
		return "User deleted successfully";
	}
	
	//<--- GetAll Method ---> 

	@Override
	public Iterable<User> getAllUsers() {
		// TODO Auto-generated method stub 
		return userRepository.findAll();
	}

	
	//<--- Save Methods ---> 
	@Override
	public String saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		return "User saved successfully";
	}

	public User save(User user) {
		// TODO Auto-generated method stub 
		userRepository.save(user);
		return user;
	}

	
 
	
}