package com.appointment.appointmentAPI.appointment.response;

import java.time.LocalDateTime;

import com.appointment.appointmentAPI.user.response.DepartmentResponse;
import com.appointment.appointmentAPI.user.response.DoctorResponseModel;
import com.appointment.appointmentAPI.user.response.PatientResponseModel;

public class AppointmentResponseModel {

	private String publicId;
	private PatientResponseModel patient;
	private DoctorResponseModel doctor;
	private LocalDateTime startTime;
	private LocalDateTime createdTime;
	private String patientNote;
	private DepartmentResponse departmentResponse;

	public String getPublicId() {
		return publicId;
	}

	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}

	
	public PatientResponseModel getPatient() {
		return patient;
	}

	public void setPatient(PatientResponseModel patient) {
		this.patient = patient;
	}

	public DoctorResponseModel getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorResponseModel doctor) {
		this.doctor = doctor;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public String getPatientNote() {
		return patientNote;
	}

	public void setPatientNote(String patientNote) {
		this.patientNote = patientNote;
	}

	public DepartmentResponse getDepartmentResponse() {
		return departmentResponse;
	}

	public void setDepartmentResponse(DepartmentResponse departmentResponse) {
		this.departmentResponse = departmentResponse;
	}

}
