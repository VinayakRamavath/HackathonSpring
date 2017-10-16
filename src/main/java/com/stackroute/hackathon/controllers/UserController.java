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
import com.stackroute.hackathon.domain.User;
import com.stackroute.hackathon.repositories.UserRepository;
import com.stackroute.hackathon.services.UserService;

@Controller    
@RequestMapping(path="/movie") 
public class UserController {
	@Autowired
	private UserService userService;
	 
	@GetMapping(path="/fetch/{id:[0-9]+}") 
	public @ResponseBody ResponseEntity<User> fetchUserByID (@PathVariable("id") int id) {  
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	} 
	 
//	@GetMapping(path="/fetch/{name:[a-zA-Z]+}") 
//	public @ResponseBody ResponseEntity<User> fetchMovieByName (@PathVariable("name") String name) {  
//		return new ResponseEntity<User>(movieService.getMovieByName(name), HttpStatus.OK);
//	}  
	@RequestMapping(value = "/save", method = RequestMethod.POST) 
	public @ResponseBody ResponseEntity<String> saveNewMovie (@RequestBody User user){ 
		return new ResponseEntity<String>(userService.saveUser(user), HttpStatus.OK);
	}
	
	 
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE) 
	public @ResponseBody ResponseEntity<String> deleteUser (@RequestBody User movie){
		System.out.println("Delete" + movie);
		return new ResponseEntity<String>(userService.deleteUser(movie), HttpStatus.OK);
	} 
//	@RequestMapping(value = "/delete/{name:[a-zA-Z]+}", method = RequestMethod.DELETE) 
//	public @ResponseBody ResponseEntity<String> deleteUserByName (@PathVariable("name") String name){ 
//		System.out.println("Delete" + name);
//		return new ResponseEntity<String>(movieService.deleteMovieByName(name), HttpStatus.OK);
//	} 
	@RequestMapping(value = "/delete/{id:[0-9]+}", method = RequestMethod.DELETE) 
	public @ResponseBody ResponseEntity<String> deleteUserById (@PathVariable("id") int id){ 
		System.out.println("Delete" + id);
		return new ResponseEntity<String>(userService.deleteUserById(id), HttpStatus.OK);
	}
	 
	@GetMapping(path="/all",produces="application/json") 
	public @ResponseBody Iterable<User> getAllUsers() { 
		return userService.getAllUsers();
	}
}
