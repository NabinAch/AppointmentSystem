package com.appointment.appointmentAPI.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.appointment.appointmentAPI.user.dto.PatientDto;

public interface UserService extends UserDetailsService{

	PatientDto createPatient(PatientDto patientDto);
	
	PatientDto updatePatient(PatientDto patientDto);
	
	PatientDto deletePatient(PatientDto patientDto);
	
	PatientDto getPatient(PatientDto patientDto);
	
}
