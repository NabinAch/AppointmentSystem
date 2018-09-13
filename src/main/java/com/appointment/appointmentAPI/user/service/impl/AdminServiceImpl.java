package com.appointment.appointmentAPI.user.service.impl;

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
import com.appointment.appointmentAPI.user.dto.AdminDto;
import com.appointment.appointmentAPI.user.dto.PatientDto;
import com.appointment.appointmentAPI.user.dto.UserDto;
import com.appointment.appointmentAPI.user.model.Admin;
import com.appointment.appointmentAPI.user.model.Patient;
import com.appointment.appointmentAPI.user.model.UserEntity;
import com.appointment.appointmentAPI.user.repository.AdminRepository;
import com.appointment.appointmentAPI.user.repository.PatientRepository;
import com.appointment.appointmentAPI.user.service.UserService;

@Service("adminServiceImpl")
public class AdminServiceImpl implements UserService {


	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto adminDto) {
		Admin admin = new Admin();
		
		admin = modelMapper.map(adminDto, Admin.class);
		admin.setUserId(utils.generateUserId(30));
		admin.setEncryptedPassword(bCryptPasswordEncoder.encode(adminDto.getPassword()));
		admin.setRole("ROLE_ADMIN");
		
		Admin storedAdmin = adminRepo.save(admin);

		UserDto returnAdmin = new AdminDto();
		returnAdmin = modelMapper.map(storedAdmin, AdminDto.class);

		return returnAdmin;
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
		
		Admin admin = adminRepo.findByEmail(username);
		if(admin == null) throw new UsernameNotFoundException(username);
		
		UserDto userdto = new AdminDto();
		userdto = modelMapper.map(admin, AdminDto.class);
		
		return userdto;
	}

	@Override
	public UserEntity getUserFromUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}


}
