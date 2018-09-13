package com.appointment.appointmentAPI.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.appointmentAPI.shared.Utils;
import com.appointment.appointmentAPI.user.dto.AppointmentDto;
import com.appointment.appointmentAPI.user.model.Appointment;
import com.appointment.appointmentAPI.user.repository.AppointmentRepository;
import com.appointment.appointmentAPI.user.service.AppointmentService;

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

		int hour = appointmentDto.getStartTime().getHour();
		int minute =appointmentDto.getStartTime().getMinute();
		
		if ((appointmentDto.getStartTime().getHour() < 8) || (appointmentDto.getStartTime().getMinute() != 0)
				|| (appointmentDto.getStartTime().getHour() > 17) || (appointmentDto.getStartTime().getHour() == 13))
			return null;
		
		appointmentDto.setPublicId(utils.generateUserId(10));
		
		Appointment appointment = modelMapper.map(appointmentDto, Appointment.class);
		
		AppointmentDto returnDto = modelMapper.map(appointmentRepo.save(appointment), AppointmentDto.class);
		return returnDto;
	}

}
