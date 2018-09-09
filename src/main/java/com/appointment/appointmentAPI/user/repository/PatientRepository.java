package com.appointment.appointmentAPI.user.repository;

import javax.transaction.Transactional;

import com.appointment.appointmentAPI.user.model.Patient;


@Transactional
public interface PatientRepository extends UserBaseRepository<Patient> {

}
