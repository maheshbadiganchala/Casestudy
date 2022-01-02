package com.practice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practice.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  
	Role findByRole(String role);
	
}
