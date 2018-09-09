package com.appointment.appointmentAPI.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appointment.appointmentAPI.shared.Utils;
import com.appointment.appointmentAPI.user.dto.PatientDto;
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
	public PatientDto createPatient(PatientDto patientDto) {
		Patient patient = new Patient();
		ModelMapper modelMapper = new ModelMapper();

		patient = modelMapper.map(patientDto, Patient.class);
		patient.setUserId(utils.generateUserId(30));
		patient.setEncryptedPassword(bCryptPasswordEncoder.encode(patientDto.getPassword()));

		Patient storedPatient = patientRepo.save(patient);

		PatientDto returnPatient = new PatientDto();
		returnPatient = modelMapper.map(storedPatient, PatientDto.class);

		return returnPatient;
	}

	@Override
	public PatientDto updatePatient(PatientDto patientDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientDto deletePatient(PatientDto patientDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientDto getPatient(PatientDto patientDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
