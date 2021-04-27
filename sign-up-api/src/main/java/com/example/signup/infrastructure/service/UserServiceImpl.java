package com.example.signup.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.signup.domain.user.User;
import com.example.signup.domain.user.UserJpaRepository;
import com.example.signup.infrastructure.dto.user.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	
	private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();
	
	private final UserJpaRepository userJpaRepository;
	
	@Autowired
	public UserServiceImpl(UserJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}

	@Override
	public User signUp(UserDTO userDto) {
		try {
			String encryptedPassword = ENCODER.encode(userDto.getPassword());
			return userJpaRepository.save(new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), encryptedPassword));
		} 
		catch(Exception e) {
			throw e;
		}
	}
}
