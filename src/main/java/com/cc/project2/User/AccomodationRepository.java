package com.cc.project2.User;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationRepository extends CrudRepository<Accomodation, Long> {
	List<Accomodation> findByUserTypeAndRoommatePreferenceAndStartDate(String userType, String roommatePreference,
			String date);
	
}
