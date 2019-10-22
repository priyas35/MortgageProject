package com.bank;

import java.util.Arrays;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



/**
 * @author Dinesh.Rajput
 *
 */
public class RemoteUserRepository implements ClientUserService {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemoteUserRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	@Override
	public int login(User user) {
		User user2 =  restTemplate.getForObject(serviceUrl + "/user/{username}",User.class, user);
		//System.out.println(user2.getUsername());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		//System.out.println(user2.getPassword());
		if (user2 != null && user.getUsername().equals(user2.getUsername()) && user.getPassword().equals(user2.getPassword())) {
			return user2.getId();
		} else {
			return 0;
		}
	}
	
	@Override
	public ResponseEntity<Integer> adduserdetails(User user) {
		ResponseEntity<Integer> result = restTemplate.postForEntity(serviceUrl + "/adduserdetails", user, Integer.class);
		return result;
	}
	
	/*
	 * @Override public User add(User user) { return
	 * restTemplate.getForObject(serviceUrl + "/add/" + "/get",User.class,user); }
	 */


}
