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
public class RemotePersonalDetailsRepository implements ClientPersonaldetailsService {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemotePersonalDetailsRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	
	
	
	@Override
	public ResponseEntity<String> registeruserdetails(Personaldetails personalDetails) {
		ResponseEntity<String> result1 = restTemplate.postForEntity(serviceUrl + "/add", personalDetails, String.class);
		return result1;
	}
   }
	 



