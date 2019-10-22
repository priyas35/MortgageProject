package com.bank;

import org.springframework.http.ResponseEntity;

public interface ClientUserService {

	public int login(User user);

	public ResponseEntity<Integer> adduserdetails(User user);

	/* public User add(User user); */
	
	}
