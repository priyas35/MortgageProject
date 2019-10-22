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
public class RemotePropertyRepository implements ClientPropertyService {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemotePropertyRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	
	
	
	@Override
	public ResponseEntity<String> registerpropertydetails(Property property) {
		ResponseEntity<String> result1 = restTemplate.postForEntity(serviceUrl + "/addproperty", property, String.class);
		return result1;
	}
	
	@Override
	public int loanamount(int id) {
		ResponseEntity<Integer> amount = restTemplate.getForEntity(serviceUrl + "/loanamount" + id, Integer.class);
		return amount.getBody();
	}
	 


}
