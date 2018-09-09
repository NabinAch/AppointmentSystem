package com.appointment.appointmentAPI.user.repository;

import javax.transaction.Transactional;

import com.appointment.appointmentAPI.user.model.Doctor;

@Transactional
public interface DoctorRepository extends UserBaseRepository<Doctor> {

}
