package com.stackroute.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.stackroute.hackathon.domain.User;
import com.stackroute.hackathon.repositories.UserRepository;
import com.stackroute.hackathon.services.UserService;

//The main controller for the whole application
@Controller    
@RequestMapping(path="/user") 
public class UserController {
	@Autowired
	private UserService userService;
	 
	//<--- Fetcher Methods ---> 
	@GetMapping(path="/fetch/{id:[0-9]+}") 
	public @ResponseBody ResponseEntity<?> fetchUserByID (@PathVariable("id") int id) { 
		try {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
	catch(Exception e) {
		User error=null;
		return new ResponseEntity<String>("User with the ID Not Found. Please check and try again.", HttpStatus.NOT_FOUND);
	}
	} 
	 
	@GetMapping(path="/fetch/{name:[a-zA-Z]+}") 
	public @ResponseBody ResponseEntity<?> getUserByName (@PathVariable("name") String name) {  
		try {
			return new ResponseEntity<User>(userService.getUserByName(name), HttpStatus.OK);
		}
		catch(Exception e) { 
			return new ResponseEntity<String>("User with the name Not Found. Please check and try again.", HttpStatus.NOT_FOUND);
		}
	}  
	
	
	
	//<--- Save Method ---> 
	
	@RequestMapping(value = "/save", method = RequestMethod.POST) 
	public @ResponseBody ResponseEntity<String> saveNewUser (@RequestBody User user){

		try {
			if(user.getEmailId() == null || user.getUsername() == null) return new ResponseEntity<String>("Please make sure that both username and email id are entered.", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<String>(userService.saveUser(user), HttpStatus.OK);
		}
		catch(Exception e) { 
			return new ResponseEntity<String>("Unable to POST. Please check and try again.", HttpStatus.NOT_FOUND);
		}
	}
	
	 
	
	//<--- Delete Methods ---> 
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE) 
	public @ResponseBody ResponseEntity<String> deleteUser (@RequestBody User movie){
		try {
		return new ResponseEntity<String>(userService.deleteUser(movie), HttpStatus.OK);
	}
	catch(Exception e) { 
		return new ResponseEntity<String>("User with the ID Not Found. Please check and try again.", HttpStatus.NOT_FOUND);
	}
	} 

	@RequestMapping(value = "/delete/{id:[0-9]+}", method = RequestMethod.DELETE) 
	public @ResponseBody ResponseEntity<String> deleteUserById (@PathVariable("id") int id){ 
		try {
			return new ResponseEntity<String>(userService.deleteUserById(id), HttpStatus.OK);
		}catch(Exception e) { 
			return new ResponseEntity<String>("User with the ID Not Found. Please check and try again.", HttpStatus.NOT_FOUND);
		}
	}
	 
	
	
	//<--- Get All Methods --->  
	@GetMapping(path="/all",produces="application/json") 
	public @ResponseBody ResponseEntity<?> getAllUsers() { 
		try {
			return new ResponseEntity<Iterable<User>>(userService.getAllUsers(), HttpStatus.OK);
		}
		catch(Exception e) { 
			return  new ResponseEntity<String>("Unable to retrieve from Database. Please ensure that the proper credentials are being used as specified in the documentation", HttpStatus.BAD_REQUEST);
		}
	}
}
