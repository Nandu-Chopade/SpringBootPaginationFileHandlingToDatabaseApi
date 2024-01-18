package com.rest.api.interview.preapration.repositroy;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.interview.preapration.model.UserDeatils;

@Repository
public interface UserRepository extends JpaRepository<UserDeatils, Long> {
    
	 // we are creating this it doesn't exist in Jpa 
	 Page<UserDeatils> findAll(Pageable pageable);
		
	 List<UserDeatils> findByFirstName(String firstName);
	 
	 List<UserDeatils> findByEmail(String email);

		 
	 
	 
}
