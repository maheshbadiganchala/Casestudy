package com.casestudy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.casestudy.Staff;
import com.casestudy.repo.StaffRepository;


@Service
public abstract class StaffService {
	
	
private StaffRepository staffrepository;
	
	public Staff addstaff( Staff staff)
	{
		return staffrepository.save(staff);
	}
    public List<Staff> getstaffs()
    {
    List<Staff>staff=staffrepository.findAll();
    return staff;
    }
  public Optional<Staff>getStaff(String id)
  {
	  return staffrepository.findById(id);
	  
  }
  public void deletestaff(Staff staff)
  {
	  staffrepository.delete(staff);
	  
  }

}
