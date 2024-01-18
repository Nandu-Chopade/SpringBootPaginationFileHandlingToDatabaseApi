package com.rest.api.interview.preapration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.interview.preapration.model.UserDeatils;
import com.rest.api.interview.preapration.services.UserService;


@RestController
@RequestMapping("/user-controller")   
public class PaginationController {
	
	@Autowired
    private UserService userService;
	
   @GetMapping("/welcome")
   public ResponseEntity<?> welcomeUser(){
	   return new ResponseEntity<String>("welcome to our service ", HttpStatus.OK);
   }
   
   @GetMapping("/get-user")
   public ResponseEntity<List<UserDeatils>> getAllUser(
		    @RequestParam(value ="pageNumber", defaultValue = "0", required = false) Integer pageNumber,
		    @RequestParam(value ="pageSize", defaultValue = "5", required = false) Integer pageSize){
	   List<UserDeatils> userdetails = userService.getUsers(pageNumber, pageSize);
	   return new ResponseEntity<List<UserDeatils>>(userdetails,HttpStatus.OK);
   }
   
   @GetMapping("/get-by-name")
   public ResponseEntity<List<UserDeatils>> getByFirstName(@RequestParam String firstName){
//	   String name = firstName.trim();
	   List<UserDeatils> userList = userService.getByFirstName(firstName);
	   return new ResponseEntity<List<UserDeatils>>(userList , HttpStatus.OK);
   }
   
   
   @GetMapping("/get-by-email")
   public ResponseEntity<List<UserDeatils>> getByEmail(@RequestParam String email){
	   List<UserDeatils> userList = userService.getByEmail(email);
	   return new ResponseEntity<List<UserDeatils>>(userList , HttpStatus.OK);
   }
}
