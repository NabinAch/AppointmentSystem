package com.appointment.appointmentAPI.user.dto;

import java.util.List;

import com.appointment.appointmentAPI.user.model.Doctor;

public class DepartmentDto {

	private long id;
	private String departmentId;
	private String departmentName;
	public List<Doctor> doctors;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

}
