package com.cc.project2.UserParent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StudentHostMatch")
public class StudentHostMatch {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long matchId;
	 	private Long acId;
	 	private Long userId;
		private String status;//Pending, Approved
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		public Long getMatchId() {
			return matchId;
		}
		public void setMatchId(Long matchId) {
			this.matchId = matchId;
		}
		public Long getAcId() {
			return acId;
		}
		public void setAcId(Long acId) {
			this.acId = acId;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
}
