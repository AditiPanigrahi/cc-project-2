package com.cc.project2.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.cc.project2.UserParent.Accomodation;
import com.cc.project2.UserParent.AccomodationRepository;
import com.cc.project2.UserParent.User;
import com.cc.project2.UserParent.UserAccomodationParentObject;
import com.cc.project2.UserParent.UserRepository;

@RestController
public class StudentController {
	
	@Autowired
	private UserRepository UserRepository;	

	@Autowired
	private AccomodationRepository AccomodationRepository;
	
	@PostMapping("/generateStudentProfile")
	public List<Accomodation> newHostListing(@RequestBody UserAccomodationParentObject userAccomodationParentObject) {
		
		List<Accomodation> hostListings  = new ArrayList<Accomodation>();
		if(userAccomodationParentObject!=null) {
			User user = userAccomodationParentObject.getUser();
			Accomodation accomodation = userAccomodationParentObject.getAccomodation();
			if(user!=null) {
				if(user.getUserType().toLowerCase()=="student") {
					return null;
				}
				UserRepository.save(user);
			}
			if(accomodation!=null) {
				AccomodationRepository.save(accomodation);
				if(accomodation != null && accomodation.getUserType()!=null 
						&& accomodation.getRoommatePreference()!=null && accomodation.getStartDate()!=null) {
				hostListings = AccomodationRepository.findByUserTypeAndRoommatePreferenceAndStartDate
						(accomodation.getUserType(), accomodation.getRoommatePreference(), 
								accomodation.getStartDate());
				}
				return hostListings;
			}
		}
		return hostListings;
	}
	
	
}
