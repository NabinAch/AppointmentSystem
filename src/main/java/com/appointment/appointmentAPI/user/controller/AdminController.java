package com.appointment.appointmentAPI.user.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.appointmentAPI.user.dto.AdminDto;
import com.appointment.appointmentAPI.user.dto.UserDto;
import com.appointment.appointmentAPI.user.request.AdminRequestModel;
import com.appointment.appointmentAPI.user.response.AdminResponseModel;
import com.appointment.appointmentAPI.user.service.UserService;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	UserService adminServiceImpl;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping
	public String getUser() {
		return "Get User";
	}

	@PostMapping
	public AdminResponseModel createUser(@RequestBody AdminRequestModel adminRequest) {
		AdminResponseModel adminResponse = new AdminResponseModel();
		
		UserDto adminDto = modelMapper.map(adminRequest, AdminDto.class);

		UserDto createdAdmin = adminServiceImpl.createUser(adminDto);

		adminResponse = modelMapper.map(createdAdmin, AdminResponseModel.class);

		return adminResponse;
	}

	@PutMapping
	public String updateUser() {
		return "Update User";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete User";
	}
}
