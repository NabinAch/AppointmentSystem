package com.appointment.appointmentAPI.appointment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.appointmentAPI.appointment.dto.AppointmentDto;
import com.appointment.appointmentAPI.appointment.model.Appointment;
import com.appointment.appointmentAPI.appointment.request.AppointmentRequestModel;
import com.appointment.appointmentAPI.appointment.response.AppointmentResponseModel;
import com.appointment.appointmentAPI.appointment.service.AppointmentService;
import com.appointment.appointmentAPI.user.dto.DepartmentDto;
import com.appointment.appointmentAPI.user.dto.DoctorDto;
import com.appointment.appointmentAPI.user.dto.PatientDto;
import com.appointment.appointmentAPI.user.model.Department;
import com.appointment.appointmentAPI.user.service.DepartmentService;
import com.appointment.appointmentAPI.user.service.UserService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	UserService patientServiceImpl;

	@Autowired
	UserService doctorServiceImpl;

	@Autowired
	AppointmentService appointmentServiceImpl;

	@Autowired
	DepartmentService departmentServiceImpl;

	@Autowired
	ModelMapper modelMapper;

	@PostMapping
	public AppointmentResponseModel createAppointment(@RequestBody AppointmentRequestModel appointmentRequest) {

		PatientDto patientDto = new PatientDto();
		patientDto = (PatientDto) patientServiceImpl.getUserFromUserId(appointmentRequest.getPatient());

		DoctorDto doctorDto = new DoctorDto();
		doctorDto = (DoctorDto) doctorServiceImpl.getUserFromUserId(appointmentRequest.getDoctor());

		DepartmentDto departmentDto = doctorDto.getDepartment();

		AppointmentDto appointmentDto = new AppointmentDto();

		modelMapper.map(appointmentRequest, appointmentDto);

		appointmentDto.setPatient(patientDto);
		appointmentDto.setDoctor(doctorDto);
		appointmentDto.setDepartment(departmentDto);

		AppointmentDto returnAppointment = appointmentServiceImpl.createAppointment(appointmentDto);
		return (modelMapper.map(returnAppointment, AppointmentResponseModel.class));
	}

	@GetMapping("/department/{id}")
	public List<AppointmentResponseModel> getAppointmentByDepartment(@PathVariable String id) {

		DepartmentDto departmentDto = departmentServiceImpl.getDepartment(id);
		Department department = new Department();
		modelMapper.map(departmentDto, department);
		List<Appointment> appointments = appointmentServiceImpl.getAppointmentByDepartment(department);

		List<AppointmentResponseModel> appointmentResponseModels = new ArrayList<>();
		appointmentResponseModels = appointments.stream()
        .map(appointment -> modelMapper.map(appointment, AppointmentResponseModel.class))
        .collect(Collectors.toList());
		
		return appointmentResponseModels;

	}

	private AppointmentResponseModel convertToDto(Appointment appointment) {
		AppointmentResponseModel appointmentResponseModel = modelMapper.map(appointment, AppointmentResponseModel.class);
		return appointmentResponseModel;
	}

}
