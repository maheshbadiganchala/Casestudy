package com.casestudy.CustomerService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public abstract class CustomerService {
	
	private CustomerRepository customerrepository;
	
	public Customer addcustomer( Customer customer)
	{
		return customerrepository.save(customer);
	}
    public List<Customer> getcustomers()
    {
    List<Customer>customer=customerrepository.findAll();
    return customer;
    }
  public Optional<Customer>getCustomer(String id)
  {
	  return customerrepository.findById(id);
	  
  }
  public void deleteCustomer(Customer customer)
  {
	  customerrepository.delete(customer);
	  
  }
  }