package com.appointment.appointmentAPI.appointment.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.appointment.appointmentAPI.user.model.Department;
import com.appointment.appointmentAPI.user.model.Doctor;
import com.appointment.appointmentAPI.user.model.Patient;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String publicId;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	@JsonManagedReference
	@ManyToOne
	private Department department;

	@Column(nullable = false, unique = true)
	private LocalDateTime startTime;

	@Column(nullable = false)
	private LocalDateTime createdTime;

	@Column(length = 200)
	private String patientNote;

	@Column(length = 200)
	private String doctorNote;
	
	@PrePersist
	protected void onCreate() {
		if(createdTime==null) {
			createdTime=LocalDateTime.now();
		}
	}

	public String getPublicId() {
		return publicId;
	}

	public void setPublicId(String publicId) {
		this.publicId = publicId;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
