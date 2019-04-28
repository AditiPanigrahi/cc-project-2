package com.cc.project2.Host;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cc.project2.UserParent.Accomodation;
import com.cc.project2.UserParent.AccomodationRepository;
import com.cc.project2.UserParent.User;
import com.cc.project2.UserParent.UserAccomodationParentObject;
import com.cc.project2.UserParent.UserRepository;

@RestController
public class HostController {
	
	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	private AccomodationRepository AccomodationRepository;
	

	@PostMapping("/generateHostProfile")
	public List<Accomodation> newHostListing(@RequestBody UserAccomodationParentObject userAccomodationParentObject) {
		if(userAccomodationParentObject!=null) {
			User user = userAccomodationParentObject.getUser();
			Accomodation accomodation = userAccomodationParentObject.getAccomodation();
			if(user!=null) {
				if(user.getUserType().toLowerCase()=="host") {
					return null;
				}
				UserRepository.save(user);
			}
			if(accomodation!=null) {
				AccomodationRepository.save(accomodation);
			}
		}
		return new ArrayList<Accomodation>();
	}
		
	@RequestMapping(value="/getUsers", method=RequestMethod.GET)
	public List<User> getUser() {
		List<User> users = (List<User>) UserRepository.findAll();
		System.out.println(UserRepository.findAll());
		return users;
	}
	
	//test request below//
	@RequestMapping(value="/dummyTestApi", method=RequestMethod.GET)
	public User testApi() {
		User user = new User();
		user.setUserType("Host");
		//user.setName("noname");
		return user;
	}
	
	
}
