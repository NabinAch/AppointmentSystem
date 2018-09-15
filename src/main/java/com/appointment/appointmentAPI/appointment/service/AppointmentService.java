package com.appointment.appointmentAPI.appointment.service;

import java.util.List;

import com.appointment.appointmentAPI.appointment.dto.AppointmentDto;
import com.appointment.appointmentAPI.appointment.model.Appointment;
import com.appointment.appointmentAPI.user.model.Department;

public interface AppointmentService {

	AppointmentDto createAppointment(AppointmentDto appointmetnDto);

	List<Appointment> getAppointmentByDepartment(Department department);
}
