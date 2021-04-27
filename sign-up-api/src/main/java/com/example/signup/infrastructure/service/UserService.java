package com.example.signup.infrastructure.service;

import com.example.signup.domain.user.User;
import com.example.signup.infrastructure.dto.user.UserDTO;

public interface UserService {
	
	public User signUp(UserDTO userDto);

}
