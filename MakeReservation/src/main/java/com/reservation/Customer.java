package com.reservation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CustomerServices")

public class Customer {
	
	
	@Id
	private Long id;
	private String name;
	private String email;
	private Number phonenumber;
	private String gender;
	private String address;
	public Customer() {}
	
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Number getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(Number phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer( Long id, String name, String email, Number phonenumber, String gender, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.gender = gender;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phonenumber=" + phonenumber
				+ ", gender=" + gender + ", address=" + address + "]";
	}
	
	

}
