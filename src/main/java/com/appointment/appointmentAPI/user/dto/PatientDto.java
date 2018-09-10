package com.appointment.appointmentAPI.user.dto;

import java.util.List;

import com.appointment.appointmentAPI.user.model.Appointment;

public class PatientDto extends UserDto{

	private AddressDto address;
	private List<Appointment> appointmentList;
	
	
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
	
	
}
