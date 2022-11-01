package com.blurdel.ssjwt.model;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {

	private static final long serialVersionUID = 1396588483690227673L;
	
	private String username;
    private String password;

    
    // Need default constructor for JSON Parsing
    public AuthenticationRequest() {
	}

	public AuthenticationRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [username=" + username + ", password=" + password + "]";
	}
	
}
