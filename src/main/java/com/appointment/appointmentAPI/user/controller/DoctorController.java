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
import com.appointment.appointmentAPI.user.dto.DoctorDto;
import com.appointment.appointmentAPI.user.dto.UserDto;
import com.appointment.appointmentAPI.user.request.AdminRequestModel;
import com.appointment.appointmentAPI.user.request.DoctorRequestModel;
import com.appointment.appointmentAPI.user.response.AdminResponseModel;
import com.appointment.appointmentAPI.user.response.DoctorResponseModel;
import com.appointment.appointmentAPI.user.service.UserService;

@RestController
@RequestMapping("doctor")
public class DoctorController {

	@Autowired
	UserService doctorServiceImpl;
	
	@Autowired
	ModelMapper modelMapper;
	

	@GetMapping
	public String getUser() {
		return "Get User";
	}

	@PostMapping
	public DoctorResponseModel createUser(@RequestBody DoctorRequestModel doctorRequest) {
		DoctorResponseModel doctorResponse = new DoctorResponseModel();

		UserDto doctorDto = modelMapper.map(doctorRequest, DoctorDto.class);

		UserDto createdDoctor = doctorServiceImpl.createUser(doctorDto);

		doctorResponse = modelMapper.map(createdDoctor, DoctorResponseModel.class);

		return doctorResponse;
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
