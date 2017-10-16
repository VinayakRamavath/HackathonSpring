package com.stackroute.hackathon;

import junit.framework.TestCase;
import junit.framework.TestSuite; 
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner; 
import com.stackroute.hackathon.Application;
import com.stackroute.hackathon.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest  extends TestCase {
   
	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	User user;    
    
	@Before
    public void setUp() throws Exception {
		user = new User(16, "akshaydv","akshay", "dv","akshay@stackroute.com");
    }
	
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testSaveUser() throws Exception { 

    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> entity = new HttpEntity<User>(user, headers); 
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/save"),
                HttpMethod.POST, entity, String.class); 
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("User saved successfully",actual); 
    }
    
    @Test
    public void testList() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/all"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);
    } 
    
    @Test
    public void testDeleteMovie() throws Exception {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> entity = new HttpEntity<User>(user, headers); 
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/delete"),
                HttpMethod.DELETE, entity, String.class); 
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("User deleted successfully",actual);
    }
    
}