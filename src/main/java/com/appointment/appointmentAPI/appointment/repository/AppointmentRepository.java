package com.appointment.appointmentAPI.appointment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appointment.appointmentAPI.appointment.model.Appointment;
import com.appointment.appointmentAPI.user.model.Department;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

	List<Appointment> findAllByDepartment(Department department);

}
