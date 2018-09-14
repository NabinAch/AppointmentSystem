package com.appointment.appointmentAPI.user.dto;

import java.util.List;

import com.appointment.appointmentAPI.appointment.model.Appointment;
import com.fasterxml.jackson.annotation.JsonBackReference;

public class DoctorDto extends UserDto{

	private DepartmentDto department;
	@JsonBackReference
	private List<Appointment> appointmentList;


	public DepartmentDto getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDto departmenDto) {
		this.department = departmenDto;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
}
