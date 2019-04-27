package com.cc.project2.Student;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cc.project2.User.Accomodation;
import com.cc.project2.User.AccomodationRepository;
import com.cc.project2.User.HostRequest;
import com.cc.project2.User.User;
import com.cc.project2.User.UserRepository;
import com.mysql.fabric.xmlrpc.base.Array;

@RestController
public class StudentController {
	
	@Autowired
	private UserRepository UserRepository;	

	@Autowired
	private AccomodationRepository AccomodationRepository;
	
	@PostMapping("/newUser")
	User newUser(@RequestBody User student) {
		return UserRepository.save(student);
	}

	@PostMapping("/newStudentListing")
	List<Accomodation> newHostListing(@RequestBody Accomodation accomodation) {
		Accomodation studentAccomodation = AccomodationRepository.save(accomodation);
		List<Accomodation> hostListings  = new ArrayList<Accomodation>();
		if(studentAccomodation != null && studentAccomodation.getUserType()!=null 
				&& studentAccomodation.getRoommatePreference()!=null && studentAccomodation.getStartDate()!=null) {
		hostListings = AccomodationRepository.findByUserTypeAndRoommatePreferenceAndStartDate
				(studentAccomodation.getUserType(), studentAccomodation.getRoommatePreference(), 
						studentAccomodation.getStartDate());
		}
		return hostListings;
		
	}
	
	
}
