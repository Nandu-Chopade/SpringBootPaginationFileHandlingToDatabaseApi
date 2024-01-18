package com.rest.api.interview.preapration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rest.api.interview.preapration.model.UserDeatils;
import com.rest.api.interview.preapration.repositroy.UserRepository;

@Service
public class UserServieceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserDeatils> getUsers(Integer pageNumber, Integer pageSize) {
		
		// Creating the reference variable for Pageable interface
		Pageable page = PageRequest.of(pageNumber, pageSize);
		
		// creating the Page List of interface and calling UserRepository's define method
		Page<UserDeatils> pagePost = userRepository.findAll(page);
		
		// converting pagePost in the list of as collection list
		List<UserDeatils> userPageObject = pagePost.getContent();
		
		return userPageObject;
	}

	@Override
	public List<UserDeatils> getByFirstName(String firstName) {
		List<UserDeatils> user =  userRepository.findByFirstName(firstName);
		return  user;
	}

	@Override
	public List<UserDeatils> getByEmail(String email) {
		List<UserDeatils> user =  userRepository.findByEmail(email);
		return user;
	}

}
