package com.stackroute.hackathon.repositories;

import org.springframework.data.repository.CrudRepository;

import com.stackroute.hackathon.domain.User; 
 
public interface UserRepository extends CrudRepository<User, Integer> { 
}
