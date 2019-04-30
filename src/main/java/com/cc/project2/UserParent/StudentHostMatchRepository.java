package com.cc.project2.UserParent;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentHostMatchRepository extends CrudRepository<StudentHostMatch, Long> {
	List<StudentHostMatch> findByUserId(Long userId);
	List<StudentHostMatch> findByAcIdAndStatus(Long acId, String status);

}
