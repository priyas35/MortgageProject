package com.priya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PropertyRepository propertyRepository;
	
	@Autowired
	PersonaldetailsRepository personalDetailsInterface;

	

	public int adduserdetails(User user) {
		User tempuser = userRepository.save(user);
		System.out.println(tempuser.getId());
		int id;
		if (tempuser != null) {
			id = tempuser.getId();
		} else {
			id = 0;
		}
		return id;
	}
	
	public String registeruserdetails(Personaldetails personalDetails) {
		System.out.println(personalDetails.getFirstname());
		System.out.println();
		System.out.println("bye");
		Personaldetails personalDetails2 = personalDetailsInterface.save(personalDetails);
		String str = "";
		if (personalDetails2 != null) {
			str = "User Details Registered";
		} else {
			str = "User Details Not Found";
		}
		return str;
	}
	
	public String registerpropertydetails(Property property) {
		System.out.println(property.getId());
		System.out.println();
		System.out.println("bye");
		Property property2 = propertyRepository.save(property);
		String str = "";
		if (property2 != null) {
			str = "property Details Registered";
		} else {
			str = "property Details Not Found";
		}
		return str;
	}
	
	public int loanAmount(int id) {
		Property loan = propertyRepository.getPropertyById(id);
		int pv = loan.getPropertyworth();
		int area=loan.getPropertyweight();
		int loanamount = 0;
		if (pv >10000) {
			loanamount=(int) (loanamount+loanamount*(0.05));
		}
		if (area >100) {
			loanamount=(int) (loanamount+loanamount*(0.05));
	}
		return loanamount;
	}

}
