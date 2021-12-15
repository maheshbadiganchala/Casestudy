package com.casestudy.CustomerService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerRepository customerrepository;
	
	@PostMapping("/addcustomer")
	public String saveCustomer(@RequestBody Customer customer)
	{
	customerrepository.save(customer);

	return "Added customer with id : " + customer.getId();
	
}

   @GetMapping("/findAllCustomers")
   public List<Customer>getCustomers()
   {
	   return customerrepository.findAll();
	   
   }
   
   @GetMapping("/findAllCustomers/{Id}")
   public Optional<Customer>getCustomer(@PathVariable String id)
   {
	   return customerrepository.findById(id);
   }
   
   @DeleteMapping("/deletecustomer/{Id}")
   public String deletecustomer(@PathVariable ("Id")  String id)
   {
	   customerrepository.deleteById(id);
	   return "Customer have been Deleted with id: "+ id;
   }
   
}