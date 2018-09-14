package com.appointment.appointmentAPI.user.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.appointmentAPI.user.dto.DepartmentDto;
import com.appointment.appointmentAPI.user.request.DepartmentRequest;
import com.appointment.appointmentAPI.user.response.DepartmentResponse;
import com.appointment.appointmentAPI.user.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	DepartmentService departmentServiceImpl;

	@PostMapping
	public DepartmentResponse createDepartment(@RequestBody DepartmentRequest departmentRequest)
	{
		DepartmentDto departmentDto = modelMapper.map(departmentRequest, DepartmentDto.class);
		
		DepartmentDto createdDept = departmentServiceImpl.createDepartment(departmentDto);
		
		DepartmentResponse returnDepartment = new DepartmentResponse();
		returnDepartment = modelMapper.map(createdDept, DepartmentResponse.class);
		
	return returnDepartment;
	}
	
	
}
