package com.appointment.appointmentAPI.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.appointmentAPI.shared.Utils;
import com.appointment.appointmentAPI.user.dto.DepartmentDto;
import com.appointment.appointmentAPI.user.model.Department;
import com.appointment.appointmentAPI.user.repository.DepartmentRepository;
import com.appointment.appointmentAPI.user.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepo;

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	Utils utils;

	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		Department department = new Department();
		departmentDto.setDepartmentId(utils.generateUserId(15));
		
		department = modelMapper.map(departmentDto, Department.class);
		
		Department createdDepartment = departmentRepo.save(department);
		return modelMapper.map(createdDepartment, DepartmentDto.class);
	}

	@Override
	public DepartmentDto getDepartment(String departmentId) {
		Department department = new Department();
		
		department = departmentRepo.findByDepartmentId(departmentId);
		
		return modelMapper.map(department, DepartmentDto.class);
	}

}
