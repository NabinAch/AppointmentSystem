package com.appointment.appointmentAPI.security;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.appointment.appointmentAPI.user.model.UserEntity;
import com.appointment.appointmentAPI.user.repository.UserRepository;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity loggedInUser = userRepo.findByEmail(email);

		if (loggedInUser == null)
			throw new UsernameNotFoundException(email);

		List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(loggedInUser.getRole());
		return new User(loggedInUser.getEmail(), loggedInUser.getEncryptedPassword(), auth);
	}

	public String getUser(String email) {

		UserEntity loggedInUser = userRepo.findByEmail(email);
		if (loggedInUser == null)
			throw new UsernameNotFoundException(email);

		return loggedInUser.getUserId();
	}
}
