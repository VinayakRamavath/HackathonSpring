package com.stackroute.hackathon.services;

import static org.junit.Assert.*; 
import org.junit.Test;
import org.junit.runner.RunWith; 
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.stackroute.hackathon.domain.User;
import com.stackroute.hackathon.repositories.UserRepository;

import org.mockito.Mock;
import org.mockito.Mockito; 
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
    @Spy
    private UserServiceImpl userServiceSpy;
    
    @Mock
    private UserRepository userRepository;
    
    @Mock
    private User user;

   @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetProductByIdIsCalledWithoutContext() throws Exception {
        //Act
	   User retrievedMovie = userServiceSpy.getUserById(5);
        //Assert
        assertThat(retrievedMovie, is(equalTo(user)));
    }
   
   @Test(expected=NullPointerException.class)
   public void shouldThrowNullPointerException_whenSaveProductIsCalledWithoutContext() throws Exception {
        //Arrange
        Mockito.doReturn(user).when(userRepository).save(user);
        //Act
        User savedProduct = userServiceSpy.save(user);
        //Assert
        assertThat(savedProduct, is(equalTo(user)));
    }

   @Test
    public void shouldVerifyThatGetProductByIdIsCalled() throws Exception {
        //Arrange
        Mockito.doReturn(user).when(userServiceSpy).getUserById(5);
        //Act
        User retrievedProduct = userServiceSpy.getUserById(5);
        //Assert
        Mockito.verify(userServiceSpy).getUserById(5);
    }
    @Test
    public void shouldVerifyThatSaveProductIsNotCalled() throws Exception {
        //Arrange
        Mockito.doReturn(user).when(userServiceSpy).getUserById(5);
        //Act
        User retrievedProduct = userServiceSpy.getUserById(5);
        //Assert
        Mockito.verify(userServiceSpy,never()).save(user);
    }
}