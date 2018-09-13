package com.appointment.appointmentAPI.user.service;

import com.appointment.appointmentAPI.user.dto.UserDto;
import com.appointment.appointmentAPI.user.model.UserEntity;

public interface UserService {

	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto);
	
	UserDto deleteUser(UserDto userDto);
	
	UserDto getUser(String userName);

	UserEntity getUserFromUserId(String userId);
	
}
