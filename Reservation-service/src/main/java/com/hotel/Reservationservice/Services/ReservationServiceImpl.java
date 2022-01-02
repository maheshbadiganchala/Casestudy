package com.hotel.Reservationservice.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotel.Reservationservice.Models.Reservation;
import com.hotel.Reservationservice.Models.ReservationList;
import com.hotel.Reservationservice.Models.Room;
import com.hotel.Reservationservice.Repository.ReservationRepo;

@Service
public class ReservationServiceImpl implements ReservationService {
@Autowired
private ReservationRepo repo;
@Autowired
private RestTemplate restTmp; @Override
public String bookRoom(Reservation res) {
Room room= restTmp.getForObject("http://localhost:8085/Room/getRoom/"+res.getRoomId(), Room.class);
if(room.isAvailable()) {
repo.save(res);
room.setAvailable(false);
restTmp.put("http://localhost:8085/Room/updateRoom", room);
return "Room Number "+room.getRoomNum()+" booked for Guest : "+res.getCustId();
}
else {
return "Room Already Booked";
}
} @Override
public ReservationList getReservations() {
ReservationList list=new ReservationList();
list.setResList(repo.findAll());
return list;
} @Override
public Reservation updateRes(Reservation res) {
return repo.save(res);
} @Override
public String deleteRes(int id) {
Optional<Reservation> res=repo.findById(id);
Reservation res1=res.get();
Room room= restTmp.getForObject("http://localhost:8085/Room/getRoom/"+res1.getRoomId(), Room.class);
room.setAvailable(true);
restTmp.put("http://localhost:8085/Room/updateRoom", room);
repo.deleteById(id);
return "Deleted Reservation ID : "+id;
}
@Override
public Optional<Reservation> getReservation(int id) {
return repo.findById(id);
}}


