package com.practice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practice.dto.hotel;
import com.practice.model.User;
import com.practice.repository.RoleRepository;
import com.practice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository repository2;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	private String url = "http://localhost:8989/hotel/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public User createUser(User user)
	{
		if(user.getRole()!=null && user.getRole().size()>0)
		{
			repository2.saveAll(user.getRole());
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return repository.save(user);
	}

     public User findUserName(String username)
     {
    	 return repository.findByUserName(username);
     }
     
     public List<hotel> getallTrain()
 	{
 		hotel[] train=restTemplate.getForObject(url+"allTrain", hotel[].class);
 		return Arrays.asList(train); 

 	}
   
   public hotel findId(int id)
 	{
 	   return restTemplate.getForObject(url+"/find/"+id, hotel.class);	
 	}
   
   public List<hotel> findName( String name)
 	{
 	   hotel[] train = restTemplate.getForObject(url+"/find-train/"+name, hotel[].class);
 	   return Arrays.asList(train);
 	}
 	
 	public List<hotel> findloc(String start,String end)
 	{
 	   hotel[] train=restTemplate.getForObject(url+"/find/"+start+"/"+end, hotel[].class);
 	   return Arrays.asList(train);
 	}
     
}
