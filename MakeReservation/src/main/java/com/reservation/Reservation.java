package com.reservation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ReservationServices")

public class Reservation {
	
	@Id
	private Long id;
	private String cust_id;
	private String roomType;
	
	private String numberOfChildren;
	private String numberOfAdults;
	private String checkInDate;
	private String checkOutDate;
	private String status;
	private String numberOfNights;
	private String roomCharges;
	
	public String getRoomCharges() {
		return roomCharges;
	}
	public void setRoomCharges(String roomCharges) {
		this.roomCharges = roomCharges;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumberOfChildren() {
		return numberOfChildren;
	}
	public void setNumberOfChildren(String numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}
	public String getNumberOfAdults() {
		return numberOfAdults;
	}
	public void setNumberOfAdults(String numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNumberOfNights() {
		return numberOfNights;
	}
	public void setNumberOfNights(String numberOfNights) {
		this.numberOfNights = numberOfNights;
	}
	public Reservation(Long id, String cust_id, String roomType, String numberOfChildren, String numberOfAdults,
			String checkInDate, String checkOutDate, String status, String numberOfNights, String roomCharges) {
		super();
		this.id = id;
		this.cust_id = cust_id;
		this.roomType = roomType;
		this.numberOfChildren = numberOfChildren;
		this.numberOfAdults = numberOfAdults;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.status = status;
		this.numberOfNights = numberOfNights;
		this.roomCharges = roomCharges;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", cust_id=" + cust_id + ", roomType=" + roomType + ", numberOfChildren="
				+ numberOfChildren + ", numberOfAdults=" + numberOfAdults + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", status=" + status + ", numberOfNights=" + numberOfNights
				+ ", roomCharges=" + roomCharges + "]";
	}
	
	

}
