package com.hotel.Roomservice.Controllers;

import java.util.Optional;

import javax.ws.rs.Path;

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

import com.hotel.Roomservice.Models.Room;
import com.hotel.Roomservice.Models.RoomList;
import com.hotel.Roomservice.Services.ManagerService;



@RestController
@RequestMapping("/Room")
public class RoomController {
	
	@Autowired
	private ManagerService service;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello manager";
	}
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/addRoom")
	public Room addRoom(@RequestBody Room room) {
		System.out.println(room.getRoomNum());
		return this.service.addRoom(room);
	}
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/getRoom/{id}")
	public Optional<Room> getRoom(@PathVariable("id") String id)
	{
		return this.service.getRoom(Integer.parseInt(id));
	}
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/updateRoom")
	public Room updateRoom(@RequestBody Room room)
	{
		return this.service.updateRoom(room);
	}
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping("/deleteRoom/{id}")
	public String deleteRoom(@PathVariable("id") String id)
	{
		return this.service.deleteRoom(Integer.parseInt(id));
	}
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/getAllRooms")
	public RoomList getAllGuest()
	{
		RoomList list=new RoomList();
		list.setAllRooms(this.service.getAllRooms());
		return list;
	}
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/getAvlRooms")
	public RoomList getAvlRooms()
	{
		RoomList list=new RoomList();
		list.setAllRooms(this.service.getAvailableRooms());
		return list;
	}
	
}
