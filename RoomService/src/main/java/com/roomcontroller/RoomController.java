package com.roomcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.google.common.base.Optional;
@RestController
@RequestMapping("/Rooms")
public class RoomController {
	@Autowired
	private RoomRepository roomrepository;
	
	@PostMapping("/addRoom")
	public String saveRoom(@RequestBody Room room){
	roomrepository.save(room);
	return "Room added with id  : " + room.getId();
	}
	@GetMapping("/findAllRooms")
	public List<Room>getRooms(){
		return roomrepository.findAll();
	}
//	@GetMapping("/findAllRooms/{id}")
//	public Optional<Room>getRoom(@PathVariable String id){
//		return roomrepository.findById(id);
//	}
	
	
	@PutMapping("/update/{id}")
	 public Room updateRoom(@PathVariable String id , @RequestBody Room room) {
		 roomrepository.save(room);
		 room.setId(id);
		 return room;
	 }
	@DeleteMapping("/deleteroom/{id}")
	public String  deleteRoom(@PathVariable String id) {
		roomrepository.deleteById(id);
		return "Room Deleted with id : " + id;
	}
}   
