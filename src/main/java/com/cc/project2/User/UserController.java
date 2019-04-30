package com.cc.project2.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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


@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private UserRepository UserRepository;
	
	@Autowired
	private AccomodationRepository AccomodationRepository;
	

	@PostMapping("/generateUserProfile")
	public void newHostListing(@RequestBody UserAccomodationParentObject userAccomodationParentObject) {
		if(userAccomodationParentObject!=null) {
			User user = userAccomodationParentObject.getUser();
			Accomodation accomodation = userAccomodationParentObject.getAccomodation();
			if(user!=null) {
				UserRepository.save(user);
			}
			if(accomodation!=null) {
				AccomodationRepository.save(accomodation);
			}
		}
		
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
