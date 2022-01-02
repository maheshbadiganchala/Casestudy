package com.hotel.Reservationservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.hotel.Reservationservice.Models.Reservation;
import com.hotel.Reservationservice.Repository.ReservationRepo;
import com.hotel.Reservationservice.Services.ReservationService;

import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class ReservationServiceApplicationTests {



@Autowired
private ReservationService service;
@MockBean
private ReservationRepo reservationrepository;

@Test
public void getReservationsTest() {

when(reservationrepository.findAll()).thenReturn(Stream
.of(new Reservation(01,01,201,"18-12-2021","20-12-2021","accept","2",2),new Reservation(02,02,202,"18-12-2021","20-12-2021","accept","3",3)).collect(Collectors.toList()));
assertEquals(2,service.getReservations().size());
}



@Test
public void saveReservationTest() {
Reservation reservation=new Reservation("01","2","3","18-12-2021","20-12-2021","accept","2");
when(reservationrepository.save(reservation)).thenReturn(reservation);
assertEquals(reservation,service.addreservation(reservation));
}

@Test
public void deleteReservationTest() {
Reservation reservation=new Reservation("01","2","3","18-12-2021","20-12-2021","accept","2");
service.deleteRes(reservation);
}





}