package com.reservation;

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
import org.springframework.web.client.RestTemplate;

import com.reservation.ReservationService;
import com.reservation.Customer;
import com.reservation.Reservation;


@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationRepository reservationrepository;
	
	@Autowired
	private ReservationService service;
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@GetMapping("/allcustomers")
	//@HystrixCommand(fallbackMethod="getFallbackCarwasher")
	public List<?> getCustomers(){
		return  this.restTemplate.getForObject("http://localhost:8082/customers/findAllTheCustomers", List.class);
	}
	

	@GetMapping("/allstafft")
	//@HystrixCommand(fallbackMethod="getFallbackCarwasher")
	public List<?> getStaffs(){
		return  this.restTemplate.getForObject("http://localhost:8080/staff/findAllThestaff", List.class);
	}
	
	
	//public List<?> getFallbackCarwasher(){
	//	return Arrays.asList(new CarWasher(0,"No",0,00000000,"No service"));
	
	//@GetMapping("/allcusto/{id}")
	//@HystrixCommand(fallbackMethod="getFallbackCarwasher")
	//public Customer getCustomer(@PathVariable Long id){
	//	return  this.restTemplate.getForObject("http://localhost:0002/customers/findCusto/"+id, Customer.class);
	//}
	
	@GetMapping("/allcusto/{id}")
	 public Customer getCustomers(@PathVariable String id){
		return  this.restTemplate.getForObject("http://customer-service/customers/findCusto/"+id, Customer.class);
	}
	
	
	@PostMapping(value="/addreservation")
	public String saveReservation(@RequestBody Reservation reservation)
	{
		reservationrepository.save(reservation);
		return "Added reservation done with id : " + reservation.getId();
	}
	@GetMapping("/findAboutTheReservation")
	   public List<Reservation>getReservations()
	   {
		   return reservationrepository.findAll();
		   
	   }
	@GetMapping("/reservation")
	   public List<Customer>getAllCustomer()
	   {
		   return service.getallCustomer();
		   
	   }
	 
	   @GetMapping("/findResetv/{id}")
	   public Optional<Reservation>getReservations(@PathVariable String id)
	   {
		   return reservationrepository.findById(id);
	   }
	   @DeleteMapping("/delete/{id}")
	   public String deletereservation(@PathVariable String id)
	   {
		   reservationrepository.deleteById(id);
		   return "Reservation have been Deleted with id: "+ id;
	   }
	   
}
