package com.cc.project2.UserParent;

import java.util.List;

public class AccomodationStatus {

	private Accomodation accomodation;
	private List<User> studentRequests;
	private String status;

	public List<User> getStudentRequests() {
		return studentRequests;
	}
	public void setStudentRequests(List<User> studentRequests) {
		this.studentRequests = studentRequests;
	}
	public Accomodation getAccomodation() {
		return accomodation;
	}
	public void setAccomodation(Accomodation accomodation) {
		this.accomodation = accomodation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
