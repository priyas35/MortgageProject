package com.bank;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ClientController {
	


	@Autowired
	ClientPersonaldetailsService clientPersonaldetailsService;

	@Autowired
	ClientUserService clientUserService;
	
	@Autowired
	ClientPropertyService clientPropertyService;
	
	
	@RequestMapping("/home")
	public ModelAndView home(ModelAndView model) {
		model.addObject("user" , new User());
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping("/Authenticate")
	public ModelAndView loginAuthrntication(@ModelAttribute User user) {
		int result = clientUserService.login(user);
		if (result == 0) {
			
			return new ModelAndView("accounthome");
				}
		else {
			return new ModelAndView("login");
		}
			
	}
	
	
	@RequestMapping(value = "/adduserdetails", method = RequestMethod.POST)
	public ModelAndView adduserdetails(HttpServletRequest request) {
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		ResponseEntity<Integer> res = clientUserService.adduserdetails(user);
		int id = res.getBody();
//		System.out.println(id);
		ModelAndView model = new ModelAndView();
		if (id != 0) {
			Personaldetails personalDetails = new Personaldetails();
			personalDetails.setId(id);
//			System.out.println(personalDetails.getId());
			model.addObject("mortgage", personalDetails);
			model.setViewName("login");
		} 
		if (id == 0) {
			model.setViewName("register");
		}
		
		return model;

	}


	@RequestMapping("/registeruser")
	public ModelAndView register() {
		ModelAndView model = new ModelAndView();
		model.addObject("register", new User());
		model.setViewName("register");
		return model;
	}
	


	
	@RequestMapping("/registerform")
	public ModelAndView personaldetails(ModelAndView model) {
		model.addObject("mortgage" , new Personaldetails());
		model.setViewName("personaldetails");
		return model;
	}
	
	@RequestMapping("/savedetails")
	public ModelAndView savedetails(@ModelAttribute Personaldetails personaldetails) {
		ModelAndView model=new ModelAndView();
		ResponseEntity<String> result=clientPersonaldetailsService.registeruserdetails(personaldetails);
		String res = result.getBody();
		if (res.equals("User Details Registered")) {
			
			model.setViewName("loanhome");
		} else {
			model.setViewName("personaldetails");
		}
		return model;
		}
	@RequestMapping("/newproperty")
	public ModelAndView newproperty(ModelAndView model) {
		model.addObject("property" , new Property());
		model.setViewName("property");
		return model;
	}
	
	@RequestMapping("/propertyform")
	public ModelAndView saveform(@ModelAttribute Property property) {
		ModelAndView model=new ModelAndView();
		ResponseEntity<String> result=clientPropertyService.registerpropertydetails(property);
		String res = result.getBody();
      if (res.equals("property Details Registered")) {
			
			model.setViewName("cibil");
		} else {
			model.setViewName("property");
		}
		return model;
		}
		
	
	@RequestMapping("/approove")
	public ModelAndView aproove(ModelAndView model) {
			model.setViewName("offer");
		return model;
	}
	
	@RequestMapping("/offer/{id}")
	public ModelAndView offer(@PathVariable("id") int id) {
		int loanamount=clientPropertyService.loanamount(id);
		System.out.println(loanamount);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("loanamount", loanamount);
		modelAndView.setViewName("final");
		return modelAndView;
	}
	
	
	@RequestMapping("/offerex")
	public ModelAndView offerex(ModelAndView model) {
		Property property=new Property();
		int loanamount=property.getLoanamount();
		    int pv=property.getPropertyworth();
		    
		    	loanamount=(int) (loanamount+loanamount*(0.05));
		    	model.addObject("loanamount", loanamount);
			model.setViewName("final");
		return model;
	}
	
	
	}
