package com.roomcontroller;

import java.lang.annotation.Documented;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document (collection="rooms")
public class Room {
	@Id
	private String id;
	private String roomno;
	private String roomtype;
	private String price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoomno() {
		return roomno;
	}
	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Room(String id, String roomno, String roomtype, String price) {
		super();
		this.id = id;
		this.roomno = roomno;
		this.roomtype = roomtype;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomno=" + roomno + ", roomtype=" + roomtype + ", price=" + price + "]";
	}
	
	

}
