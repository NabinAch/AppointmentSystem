package com.appointment.appointmentAPI.user.service;

import com.appointment.appointmentAPI.user.dto.PatientDto;

public interface PatientService {

	PatientDto createPatient(PatientDto patientDto);
	
	PatientDto updatePatient(PatientDto patientDto);
	
	PatientDto deletePatient(PatientDto patientDto);
	
	PatientDto getPatient(PatientDto patientDto);
	
}
