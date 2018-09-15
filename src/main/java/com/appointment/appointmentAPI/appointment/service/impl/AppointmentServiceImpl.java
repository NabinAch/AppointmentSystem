package com.appointment.appointmentAPI.appointment.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.appointmentAPI.appointment.dto.AppointmentDto;
import com.appointment.appointmentAPI.appointment.model.Appointment;
import com.appointment.appointmentAPI.appointment.repository.AppointmentRepository;
import com.appointment.appointmentAPI.appointment.service.AppointmentService;
import com.appointment.appointmentAPI.shared.Utils;
import com.appointment.appointmentAPI.user.model.Department;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	Utils utils;
	
	@Autowired
	AppointmentRepository appointmentRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public AppointmentDto createAppointment(AppointmentDto appointmentDto) {

		if ((appointmentDto.getStartTime().getHour() < 8) || (appointmentDto.getStartTime().getMinute() != 0)
				|| (appointmentDto.getStartTime().getHour() > 17) || (appointmentDto.getStartTime().getHour() == 13))
			return null;
		
		appointmentDto.setPublicId(utils.generateUserId(10));
		
		Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
		
		AppointmentDto returnDto = modelMapper.map(appointmentRepo.save(appointment), AppointmentDto.class);
		return returnDto;
	}

	@Override
	public List<Appointment> getAppointmentByDepartment(Department department) {
		return appointmentRepo.findAllByDepartment(department);
	}

}
