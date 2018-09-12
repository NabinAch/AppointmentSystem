package com.appointment.appointmentAPI.user.service;

import com.appointment.appointmentAPI.user.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto);
	
	UserDto deleteUser(UserDto userDto);
	
	UserDto getUser(String userName);
	
}
