package com.appointment.appointmentAPI.appointment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appointment.appointmentAPI.appointment.model.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
