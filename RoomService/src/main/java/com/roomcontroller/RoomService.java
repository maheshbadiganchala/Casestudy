package com.roomcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomrepository;
	
	public Room addRoom (Room room) {
		return roomrepository.save(room);

	}
	public List<Room>getRooms(){
		List<Room> rooms=roomrepository.findAll();
		return rooms;
	}
	public java.util.Optional<Room> getRoom(String id){
		return roomrepository.findById(id);
	}
    public void deleteRoom(Room room) {
    	roomrepository.delete(room);
    }
}
