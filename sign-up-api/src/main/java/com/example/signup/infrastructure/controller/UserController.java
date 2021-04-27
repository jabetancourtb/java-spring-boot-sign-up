package com.example.signup.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.signup.domain.user.User;
import com.example.signup.infrastructure.dto.user.UserDTO;
import com.example.signup.infrastructure.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping 
	@CrossOrigin("*")
	public ResponseEntity<User> signUp(@RequestBody UserDTO userDto) {
		User user = userService.signUp(userDto);
		try {
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
	}
}
