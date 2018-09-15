package com.appointment.appointmentAPI.appointment.dto;

import java.time.LocalDateTime;

import com.appointment.appointmentAPI.user.dto.DepartmentDto;
import com.appointment.appointmentAPI.user.dto.DoctorDto;
import com.appointment.appointmentAPI.user.dto.PatientDto;

public class AppointmentDto {

	private Long id;
	private String publicId;
	private PatientDto patient;
	private DoctorDto doctor;
	private LocalDateTime startTime;
	private LocalDateTime createdTime;
	private String patientNote;
	private String doctorNote;
	private DepartmentDto department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPublicId() {
		return publicId;
	}

	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}


	public PatientDto getPatient() {
		return patient;
	}

	public void setPatient(PatientDto patient) {
		this.patient = patient;
	}

	public DoctorDto getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDto doctor) {
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

	public String getDoctorNote() {
		return doctorNote;
	}

	public void setDoctorNote(String doctorNote) {
		this.doctorNote = doctorNote;
	}

	public DepartmentDto getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDto departmentDto) {
		this.department = departmentDto;
	}

}
