package com.casestudy.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.Staff;

@Repository
public interface StaffRepository extends MongoRepository<Staff,String> {

}
