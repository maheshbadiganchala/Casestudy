package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.hotel;
import com.practice.model.User;
import com.practice.model.UserRequest;
import com.practice.model.UserResponse;
import com.practice.repository.UserRepository;
import com.practice.service.UserService;
import com.practice.util.JwtUtil;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserRepository repo;
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/create")
	public User create(@RequestBody User user)
	{
		return service.createUser(user);
	}
	
	
	
	// Authentication for login
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/authenticates")
	public UserResponse genenrateTokenForUser(@RequestBody UserRequest request)throws Exception
	{
		try
		{

			if(repo.findByUserName(request.getUsername()).getRole()!=null) {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
						);
				
			}
			else
			{
				throw new Exception("Role is not defined");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Invalid Credential");
		}
		String token = util.generateToken(request.getUsername());
		return new UserResponse(token);
	}
	
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/user/{username}")
	public User getByName(@PathVariable("username") String username)
	{
	  return service.findUserName(username);	
	}
	
	
	
}

