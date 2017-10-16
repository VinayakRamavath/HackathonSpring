package com.stackroute.hackathon.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
     
    
    public User() {}; 

	@Id
	@Column(name="id")
    private Integer id;
	
    @Column(name="username")
    private String username;
	
    @Column(name="firstname")
    private String firstname;
    
    @Column(name="lastname")
    private String lastname; 
    
    @Column(name="emailId")
    private String emailId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public User(Integer id, String username, String firstName, String lastname, String emailId) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstName;
		this.lastname = lastname;
		this.emailId = emailId;
	} 
 
    
}

