package com.cc.project2.Host;

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
import com.cc.project2.UserParent.AccomodationStatus;
import com.cc.project2.UserParent.StudentHostMatch;
import com.cc.project2.UserParent.StudentHostMatchRepository;
import com.cc.project2.UserParent.User;
import com.cc.project2.UserParent.UserAccomodationParentObject;
import com.cc.project2.UserParent.UserRepository;


@CrossOrigin
@RestController
public class HostController {

	@Autowired
	private UserRepository UserRepository;

	@Autowired
	private AccomodationRepository AccomodationRepository;

	@Autowired
	private StudentHostMatchRepository studeHostMatchRepository;

	@PostMapping("/generateHostHomePage")
	public List<Accomodation> getHostListings(@RequestBody UserAccomodationParentObject userAccomodationParentObject) {

		List<Accomodation> hostListings  = new ArrayList<Accomodation>();
		if(userAccomodationParentObject!=null) {
			User user = userAccomodationParentObject.getUser();
			if(user==null) {
				return null;
			}
			//	aAccomodation accomodation = userAccomodationParentObject.getAccomodation();
			String username = user.getUserName();
			String password = user.getPassword();
			List<User> userList=UserRepository.findByUserNameAndPassword(username, password);
			if(userList==null && userList.get(0)==null) {
				return null;
			}
			Long userId = userList.get(0).getUserId();
			hostListings = AccomodationRepository.findByUsername(username);
			if(hostListings==null || hostListings.get(0)==null) {
				return null;
			}

		}
		return hostListings;
	}
	@PostMapping("/getStudentRequestsAgainstAccomodation")
	public List<User> getStudentRequestsForAccomodation(@RequestBody UserAccomodationParentObject userAccomodationParentObject) {
		List<User> studentsForAccomodation = new ArrayList<User>();
		if(userAccomodationParentObject!=null) {

			User user = userAccomodationParentObject.getUser();
			Accomodation accomodation = userAccomodationParentObject.getAccomodation();
			Long acId = accomodation.getAcId();
			List<StudentHostMatch> matchedStudentsToListedAcc= studeHostMatchRepository.findByAcIdAndStatus(acId, "Pending");
			for(StudentHostMatch student : matchedStudentsToListedAcc) {
				Long studentId = student.getUserId();
				if(studentId!=null) {
					User studentRequest = UserRepository.findByUserId(studentId);
					studentsForAccomodation.add(studentRequest);
				}
			}
		}
		return studentsForAccomodation;
	}



	@PostMapping("/approveAccomodationFromStudent")
	public void studentRequest(@RequestBody StudentHostMatch studentHostMatch) {
		if(studentHostMatch == null || studentHostMatch.getAcId()==null || studentHostMatch.getUserId()==null) {
			return;
		}	
		studentHostMatch.setStatus("ApprovedByHost");
		studeHostMatchRepository.save(studentHostMatch);
	}
}
