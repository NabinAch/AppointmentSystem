package com.appointment.appointmentAPI.appointment.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.appointmentAPI.appointment.dto.AppointmentDto;
import com.appointment.appointmentAPI.appointment.request.AppointmentRequestModel;
import com.appointment.appointmentAPI.appointment.response.AppointmentResponseModel;
import com.appointment.appointmentAPI.appointment.service.AppointmentService;
import com.appointment.appointmentAPI.user.model.Doctor;
import com.appointment.appointmentAPI.user.model.Patient;
import com.appointment.appointmentAPI.user.service.UserService;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
	
	@Autowired
	UserService patientServiceImpl;

	@Autowired
	UserService doctorServiceImpl;

	@Autowired
	AppointmentService appointmentServiceImpl;
	
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping
	public AppointmentResponseModel createAppointment(@RequestBody AppointmentRequestModel appointmentRequest) {
		
		Patient patient = new Patient();
		patient = (Patient) patientServiceImpl.getUserFromUserId(appointmentRequest.getPatientId());
		
		Doctor doctor = new Doctor();
		doctor = (Doctor) doctorServiceImpl.getUserFromUserId(appointmentRequest.getDoctorId());
		
		AppointmentDto appointmentDto = new AppointmentDto();
		
		appointmentDto.setPatient(patient);
		appointmentDto.setDoctor(doctor);
		appointmentDto.setStartTime(appointmentRequest.getStartTime());
		appointmentDto.setPatientNote(appointmentRequest.getPatientNote());
		
		AppointmentDto returnAppointment = appointmentServiceImpl.createAppointment(appointmentDto);
		return (modelMapper.map(returnAppointment, AppointmentResponseModel.class));
	}

	
}
