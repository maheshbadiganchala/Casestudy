package com.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
private String token;

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

public UserResponse(String token) {
	super();
	this.token = token;
}

@Override
public String toString() {
	return "UserResponse [token=" + token + "]";
}

}
