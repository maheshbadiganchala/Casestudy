package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.casestudy.Admin;
import com.casestudy.JwtRequest;
import com.casestudy.JwtResponse;
import com.casestudy.AdminRepo.AdminRepository;
import com.casestudy.Utility.JWTUtility;


@RestController
@RequestMapping("/user")
public class AdminController {
	@Autowired
	private AdminRepository adminrepo;
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@GetMapping("/")
	public String home() {
		return "Welocome Admin";
	}
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest ) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							jwtRequest.getUsername(),
							jwtRequest.getPassword()
							)
					);
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credentials",e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		final String token = jwtUtility.generateToken(userDetails);
		return new JwtResponse(token);
	}

	
	@PostMapping("/addAdmin")
	public String saveAdmin(@RequestBody Admin admin) {
		adminrepo.save(admin);
		return "Admin added";
    }
	@GetMapping("/findAllAdmin")
	public List<Admin> getAdmin(){
		return adminrepo.findAll();
		
	}
	

}



