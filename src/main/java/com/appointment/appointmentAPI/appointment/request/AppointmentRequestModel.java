package com.appointment.appointmentAPI.appointment.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppointmentRequestModel {

	private String patient;
	private String doctor;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime startTime;
	private String patientNote;


	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public String getPatientNote() {
		return patientNote;
	}

	public void setPatientNote(String patientNote) {
		this.patientNote = patientNote;
	}

}
