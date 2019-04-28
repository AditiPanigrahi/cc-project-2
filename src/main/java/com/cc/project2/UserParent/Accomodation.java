package com.cc.project2.UserParent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Accomodation")
public class Accomodation {
		@Id
	 	private Long userId;
		private String userType;
	    private String startDate;
	    private String endDate;
	    private String roommatePreference;
	    private String otherInfo;
	    //for host
	    private String noOfRooms;
	    private String noOfBathrooms;
	    private String address;
	    //for Student
	    //nothing yet!
	    
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		public String getNoOfRooms() {
			return noOfRooms;
		}
		public void setNoOfRooms(String noOfRooms) {
			this.noOfRooms = noOfRooms;
		}
		public String getNoOfBathrooms() {
			return noOfBathrooms;
		}
		public void setNoOfBathrooms(String noOfBathrooms) {
			this.noOfBathrooms = noOfBathrooms;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getRoommatePreference() {
			return roommatePreference;
		}
		public void setRoommatePreference(String roommatePreference) {
			this.roommatePreference = roommatePreference;
		}
		public String getOtherInfo() {
			return otherInfo;
		}
		public void setOtherInfo(String otherInfo) {
			this.otherInfo = otherInfo;
		}
		public String getUserType() {
			return userType;
		}
		public void setUserType(String userType) {
			this.userType = userType;
		}
		
}
