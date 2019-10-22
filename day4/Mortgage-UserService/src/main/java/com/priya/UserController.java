package com.priya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userRepositoryImpl;
	
	@Autowired
	PersonaldetailsRepository personaldetailsRepository;
	
	@Autowired
	PropertyRepository propertyRepository;

	
	@RequestMapping("/user/{username}")
	public User byUsername(@PathVariable("username") String username) {
		//System.out.println("inside by id" +userName);
		User user = (User) userRepository.getUserByusername(username);
		return user;
	}
	
	
	
	  @RequestMapping("/adduserdetails") 
	  public int adduserdetails(@RequestBody User user) {
			return userRepositoryImpl.adduserdetails(user);
		}
	  
	  @RequestMapping("/add") 
	  public String registeruserdetails(@RequestBody Personaldetails personalDetails) {
			return userRepositoryImpl.registeruserdetails(personalDetails);
		}
	  
	  @RequestMapping("/addproperty") 
	  public String registeruserdetails(@RequestBody Property property) {
			return userRepositoryImpl.registerpropertydetails(property);
		}
	  
	  @RequestMapping("/loanamount/{id}")
		public int loanAmount(@PathVariable("id") int loanid) {
			return userRepositoryImpl.loanAmount(loanid);
		}

	 
	
}
