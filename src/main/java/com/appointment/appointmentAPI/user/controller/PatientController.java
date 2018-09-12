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

import com.appointment.appointmentAPI.user.dto.PatientDto;
import com.appointment.appointmentAPI.user.dto.UserDto;
import com.appointment.appointmentAPI.user.model.Appointment;
import com.appointment.appointmentAPI.user.model.Doctor;
import com.appointment.appointmentAPI.user.model.Patient;
import com.appointment.appointmentAPI.user.request.PatientRequestModel;
import com.appointment.appointmentAPI.user.response.PatientResponseModel;
import com.appointment.appointmentAPI.user.service.UserService;

@RestController
@RequestMapping("patient")
public class PatientController {

	@Autowired
	UserService patientServiceImpl;
	
	@Autowired
	ModelMapper modelMapper;

	@GetMapping
	public Appointment getUser() {
		Patient patient = new Patient();
		Doctor doctor = new Doctor();
		Appointment appointment = new Appointment();
		return appointment;
	}

	@PostMapping
	public PatientResponseModel createUser(@RequestBody PatientRequestModel patientRequest) {
		PatientResponseModel patientResponse = new PatientResponseModel();
		
		UserDto patientDto = modelMapper.map(patientRequest, PatientDto.class);

		UserDto createdPatient = patientServiceImpl.createUser(patientDto);

		patientResponse = modelMapper.map(createdPatient, PatientResponseModel.class);

		return patientResponse;
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
