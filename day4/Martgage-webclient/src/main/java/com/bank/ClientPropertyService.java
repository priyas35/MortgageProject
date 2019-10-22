package com.bank;

import org.springframework.http.ResponseEntity;

public interface ClientPropertyService {

	

	public ResponseEntity<String> registerpropertydetails(Property property);

	public int loanamount(int id);
	/* public User add(User user); */
	

}
