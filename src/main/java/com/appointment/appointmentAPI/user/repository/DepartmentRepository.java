package com.appointment.appointmentAPI.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.appointment.appointmentAPI.user.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

	Department findByDepartmentId(String deptId);
}
