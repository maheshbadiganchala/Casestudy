package com.reservation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import com.reservation.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationrepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Reservation addreservation(Reservation reservation)
	{
		return reservationrepository.save(reservation);
	}
	
		public List<Reservation> getreservations(){
			List<Reservation> reservation= reservationrepository.findAll();
			return reservation;
	}
	
	public List<Customer> getallCustomer(){
		Customer[] customer= restTemplate.getForObject("http://localhost:0002/customers/findAllTheCustomers",Customer[].class);
		return Arrays.asList(customer); 
	}
	public Customer findId(Long id)
 	{
 	   return restTemplate.getForObject("http://localhost:0002/customers/findCusto/"+id, Customer.class);	
 	}
	

		public Optional<Reservation> getReservation(String id)
		{
			return reservationrepository.findById(id);
		}
		public void deleteReservation(Reservation reservation)
		{
			reservationrepository.delete(reservation);
		}
}

