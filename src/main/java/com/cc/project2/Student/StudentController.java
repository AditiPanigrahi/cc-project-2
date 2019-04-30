package com.cc.project2.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cc.project2.UserParent.Accomodation;
import com.cc.project2.UserParent.AccomodationRepository;
import com.cc.project2.UserParent.AccomodationStatus;
import com.cc.project2.UserParent.StudentHostMatch;
import com.cc.project2.UserParent.StudentHostMatchRepository;
import com.cc.project2.UserParent.User;
import com.cc.project2.UserParent.UserAccomodationParentObject;
import com.cc.project2.UserParent.UserRepository;

@CrossOrigin
@RestController
public class StudentController {

	@Autowired
	private UserRepository UserRepository;	

	@Autowired
	private AccomodationRepository AccomodationRepository;

	@Autowired
	private StudentHostMatchRepository studentHostMatchRepository;


	@PostMapping("/studentLogin")
	public List<AccomodationStatus> studentLogin(@RequestBody UserAccomodationParentObject userAccomodationParentObject) {

		List<AccomodationStatus> hostListings  = new ArrayList<AccomodationStatus>();
		if(userAccomodationParentObject!=null) {
			User user = userAccomodationParentObject.getUser();
			if(user==null)
				return null;
			//	Accomodation accomodation = userAccomodationParentObject.getAccomodation();
			if(user.getUserType().toLowerCase()=="student") {
				String username = user.getUserName();
				String password = user.getPassword();
				List<User> userList=UserRepository.findByUserNameAndPassword(username, password);
				if(userList==null && userList.get(0)==null) {
					return null;
				}
				Long userId = userList.get(0).getUserId();
				List<Accomodation> accomodationList = AccomodationRepository.findByUsername(username);
				if(accomodationList==null || accomodationList.get(0)==null) {
					return null;
				}
				Accomodation accomodation = accomodationList.get(0);
				List<Accomodation> accomodationListMatched = new ArrayList<Accomodation>();
				if(accomodation != null && accomodation.getUserType()!=null 
						&& accomodation.getRoommatePreference()!=null && accomodation.getStartDate()!=null) {
					accomodationListMatched = AccomodationRepository.findByUserTypeAndRoommatePreferenceAndStartDate
							(accomodation.getUserType(), accomodation.getRoommatePreference(), 
									accomodation.getStartDate());
				}
				for(Accomodation matchedAc: accomodationListMatched) {
					User student = UserRepository.findByUserName(username);
					List<StudentHostMatch> match = studentHostMatchRepository.findByUserId(student.getUserId());
					AccomodationStatus accomodationStatus = new AccomodationStatus();
					for(StudentHostMatch studentHostMatch: match) {
						if(matchedAc.getAcId()==studentHostMatch.getAcId()) {
							accomodationStatus.setAccomodation(matchedAc);
							accomodationStatus.setStatus(studentHostMatch.getStatus());
						}
						else {
							accomodationStatus.setAccomodation(matchedAc);
							accomodationStatus.setStatus(null);
						}
					}
					hostListings.add(accomodationStatus);
				}
			}
		}
		return hostListings;
	}

	@PostMapping("/requestAccomodationFromHost")
	public void studentReuqest(@RequestBody UserAccomodationParentObject userAccomodationParentObject) {
		if(userAccomodationParentObject == null) {
			return;
		}
		Accomodation accRequested = userAccomodationParentObject.getAccomodation();
		User student = userAccomodationParentObject.getUser();
		if(student== null || accRequested == null) {
			return;
		}
		StudentHostMatch studentHostMatch = new StudentHostMatch();
		studentHostMatch.setStatus("Pending");
		studentHostMatch.setAcId(accRequested.getAcId());
		studentHostMatch.setUserId(student.getUserId());
		studentHostMatchRepository.save(studentHostMatch);
	}
}
