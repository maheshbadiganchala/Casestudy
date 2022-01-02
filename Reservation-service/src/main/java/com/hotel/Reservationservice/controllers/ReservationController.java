package com.hotel.Reservationservice.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.Reservationservice.Models.Reservation;
import com.hotel.Reservationservice.Models.ReservationList;
import com.hotel.Reservationservice.Services.ReservationService;

@RestController
@RequestMapping("/Reservation")
@CrossOrigin("http://localhost:4200")
public class ReservationController {
@Autowired
private ReservationService service;
@PostMapping("/bookRoom")
@CrossOrigin("http://localhost:4200")
public String bookRoom(@RequestBody Reservation res)
{
return this.service.bookRoom(res);
}
@GetMapping("/getReservations")
@CrossOrigin("http://localhost:4200")
public ReservationList getReservation()
{
return this.service.getReservations();
}
@PutMapping("/updateReservation")
@CrossOrigin("http://localhost:4200")
public Reservation updateReservation(@RequestBody Reservation res)
{
return this.service.updateRes(res);
}
@DeleteMapping("/deleteReservation/{id}")
@CrossOrigin("http://localhost:4200")
public String deleteReservation(@PathVariable String id)
{
return this.service.deleteRes(Integer.parseInt(id));
}
@GetMapping("/getReservation/{id}")
@CrossOrigin("http://localhost:4200")
public Optional<Reservation> getReservation(@PathVariable("id") String id)
{
return this.service.getReservation(Integer.parseInt(id));
}
}

