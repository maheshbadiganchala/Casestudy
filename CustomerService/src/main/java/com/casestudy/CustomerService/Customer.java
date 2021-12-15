package com.casestudy.CustomerService;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CustomerServices")

public class Customer {
	
	
	@Id
	private String id;
	private String name;
	private String email;
	private Number phonenumber;
	private String check_in;
	private String check_out;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getCheck_in() {
		return check_in;
	}
	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}
	public String getCheck_out() {
		return check_out;
	}
	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}
	public Customer(String id, String name, String email, Number phonenumber, String check_in, String check_out) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.check_in = check_in;
		this.check_out = check_out;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phonenumber=" + phonenumber
				+ ", check_in=" + check_in + ", check_out=" + check_out + "]";
	}
	
	

}
