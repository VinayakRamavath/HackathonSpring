package com.stackroute.hackathon.services;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.stackroute.hackathon.domain.User;
import com.stackroute.hackathon.exceptions.UserNotFoundException;
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
	public User getUserById(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub  
		User user = userRepository.findOne(id); 
		if(user == null) throw new UserNotFoundException("User with ID not found!"); 
		return user;
	} 
	
	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//<--- Delete Methods ---> 
	@Override
	public String deleteUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		if(!userRepository.exists(user.getId())) throw new UserNotFoundException("Couldn't delete user. User with ID not found!"); 
		userRepository.delete(user);
		return "User deleted successfully";
	}

	@Override
	public String deleteUserById(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			User user = getUserById(id);
			userRepository.delete(id);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			throw new UserNotFoundException("Couldn't delete user. User with ID not found!");
		}
		
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

	public String updateUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub   
		
		if(!userRepository.exists(user.getId())) throw new UserNotFoundException("Couldn't update user. User with ID not found!");
		userRepository.save(user);
		return "User updated successfully";
	}

	 
	
}