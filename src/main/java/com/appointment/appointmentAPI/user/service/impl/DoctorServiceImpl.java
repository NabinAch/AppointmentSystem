package com.appointment.appointmentAPI.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appointment.appointmentAPI.shared.Utils;
import com.appointment.appointmentAPI.user.dto.DoctorDto;
import com.appointment.appointmentAPI.user.dto.UserDto;
import com.appointment.appointmentAPI.user.model.Doctor;
import com.appointment.appointmentAPI.user.repository.DoctorRepository;
import com.appointment.appointmentAPI.user.service.UserService;

@Service("doctorServiceImpl")
public class DoctorServiceImpl implements UserService {


	@Autowired
	DoctorRepository doctorRepo;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto doctorDto) {
		Doctor doctor = new Doctor();
		
		doctor = modelMapper.map(doctorDto, Doctor.class);
		doctor.setUserId(utils.generateUserId(30));
		doctor.setEncryptedPassword(bCryptPasswordEncoder.encode(doctorDto.getPassword()));
		doctor.setRole("ROLE_DOCTOR");
		
		Doctor storedDoctor = doctorRepo.save(doctor);

		UserDto returnDoctor = new DoctorDto();
		returnDoctor = modelMapper.map(storedDoctor, DoctorDto.class);

		return returnDoctor;
	}

	@Override
	public UserDto updateUser(UserDto patientDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto deleteUser(UserDto patientDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUser(String username) {
		
		Doctor doctor = doctorRepo.findByEmail(username);
		if(doctor == null) throw new UsernameNotFoundException(username);
		
		UserDto userdto = new DoctorDto();
		userdto = modelMapper.map(doctor, DoctorDto.class);
		
		return userdto;
	}

}
