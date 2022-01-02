package com.practice.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

	@Id
	private String uid;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String phoneNumber;
	private String gender;
	private String email;
	private String password;
	private String address;
	
	@DBRef
	private Set<Role> role;
	
	@Indexed(unique = true)
	private String userName;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(String uid, String first_name, String middle_name, String last_name, String phoneNumber, String gender,
			String email, String password, String address, Set<Role> role, String userName) {
		super();
		this.uid = uid;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.address = address;
		this.role = role;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", first_name=" + first_name + ", middle_name=" + middle_name + ", last_name="
				+ last_name + ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", email=" + email + ", password="
				+ password + ", address=" + address + ", role=" + role + ", userName=" + userName + "]";
	}
	
	
	
}
