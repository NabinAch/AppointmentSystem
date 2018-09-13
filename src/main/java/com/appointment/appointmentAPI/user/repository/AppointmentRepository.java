package com.appointment.appointmentAPI.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appointment.appointmentAPI.user.model.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
