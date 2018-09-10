package com.appointment.appointmentAPI.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.appointment.appointmentAPI.user.dto.UserDto;

public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto);
	
	UserDto deleteUser(UserDto userDto);
	
	UserDto getUser(String userName);
	
}
