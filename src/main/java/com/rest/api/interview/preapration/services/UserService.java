package com.rest.api.interview.preapration.services;

import java.util.List;

import com.rest.api.interview.preapration.model.UserDeatils;

public interface UserService {
    
	public List<UserDeatils> getUsers(Integer pageNumber, Integer pageSize);

	public  List<UserDeatils> getByFirstName(String firstName);

	public List<UserDeatils> getByEmail(String email);
}
