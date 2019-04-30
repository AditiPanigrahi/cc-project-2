package com.cc.project2.UserParent;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationRepository extends CrudRepository<Accomodation, Long> {
	List<Accomodation> findByUserTypeAndRoommatePreferenceAndStartDate(String userType, String roommatePreference,
			String date);
	List<Accomodation> findByAcId(Long id);
	List<Accomodation> findByUsername(String username);

}
