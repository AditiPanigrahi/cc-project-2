package com.cc.project2.User;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationRepository extends CrudRepository<Accomodation, Long> {
	
}
