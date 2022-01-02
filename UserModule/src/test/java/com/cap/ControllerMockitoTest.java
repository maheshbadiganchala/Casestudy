package com.cap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.practice.controller.UserController;
import com.practice.model.Role;
import com.practice.model.User;
import com.practice.service.UserService;

@SpringBootTest(classes=ControllerMockitoTest.class)
public class ControllerMockitoTest {

	@InjectMocks
	UserController controller;
	
	
	@Mock
	UserService service;
	
     User user;
     
     @Mock
     PasswordEncoder passwordEncoder;
     
  
     
	
	@Test
	public void TestAddUser()
	{

		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","User"));
		 user = new User ("1","mahesh","pandu","Nanda","xyz@gmail.com","1234",null, null, null, role1,"maheshh");
		 when(service.createUser(user)).thenReturn(user);
		 assertEquals(user,controller.create(user));
     	
 
	}

	
	@Test
	public void TestFindByName()
	{

		Set<Role> role1 = new HashSet<Role>();
		role1.add(new Role("1","User"));
		 user = new User ("1","mahesh","pandu","Nanda","xyz@gmail.com","1234",null, null, null, role1,"maheshh");
		 when(service.findUserName("Tarunk")).thenReturn(user);
		 
		 assertEquals(user,controller.getByName("maheshh"));
		
	}
}
