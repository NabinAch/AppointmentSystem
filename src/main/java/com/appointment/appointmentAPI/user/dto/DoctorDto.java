package com.appointment.appointmentAPI.user.dto;

import java.util.List;

import com.appointment.appointmentAPI.user.model.Appointment;

public class DoctorDto extends UserDto{

	private String department;
	private List<Appointment> appointmentList;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
}
