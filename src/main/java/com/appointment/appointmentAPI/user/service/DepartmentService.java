package com.appointment.appointmentAPI.user.service;

import com.appointment.appointmentAPI.user.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto createDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartment(String departmentId);
}
