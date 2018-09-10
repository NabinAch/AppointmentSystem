package com.appointment.appointmentAPI.user.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appointment.appointmentAPI.shared.Utils;
import com.appointment.appointmentAPI.user.dto.PatientDto;
import com.appointment.appointmentAPI.user.dto.UserDto;
import com.appointment.appointmentAPI.user.model.Patient;
import com.appointment.appointmentAPI.user.repository.PatientRepository;
import com.appointment.appointmentAPI.user.service.UserService;

@Service
public class PatientServiceImpl implements UserService {

	@Autowired
	PatientRepository patientRepo;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto patientDto) {
		Patient patient = new Patient();
		ModelMapper modelMapper = new ModelMapper();

		patient = modelMapper.map(patientDto, Patient.class);
		patient.setUserId(utils.generateUserId(30));
		patient.setEncryptedPassword(bCryptPasswordEncoder.encode(patientDto.getPassword()));
		patient.setRole("ROLE_PATIENT");
		
		Patient storedPatient = patientRepo.save(patient);

		UserDto returnPatient = new PatientDto();
		returnPatient = modelMapper.map(storedPatient, PatientDto.class);

		return returnPatient;
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
		
		Patient patient = patientRepo.findByEmail(username);
		if(patient == null) throw new UsernameNotFoundException(username);
		
		ModelMapper modelMapper = new ModelMapper();
		
		UserDto userdto = new PatientDto();
		userdto = modelMapper.map(patient, PatientDto.class);
		
		return userdto;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Patient patient = patientRepo.findByEmail(email);
		
		if(patient == null) throw new UsernameNotFoundException(email);
		
		List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(patient.getRole());
		return new User(patient.getEmail(), patient.getEncryptedPassword(), auth);
	}

}
