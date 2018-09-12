package com.appointment.appointmentAPI.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	private final LoginService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurity(LoginService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.POST, "/patient")
		.permitAll()
		.antMatchers(HttpMethod.GET, "/patient", "/admin").hasAuthority("ROLE_ADMIN")
		.antMatchers(HttpMethod.PUT, "/patient").hasAnyAuthority("ROLE_PATIENT","ROLE_ADMIN")
		.antMatchers(HttpMethod.DELETE, "/patient").hasAnyAuthority("ROLE_PATIENT","ROLE_ADMIN")
		.antMatchers(HttpMethod.POST, "/doctor", "/admin").hasAuthority("ROLE_ADMIN")
		.antMatchers(HttpMethod.PUT, "/doctor", "/admin").hasAuthority("ROLE_ADMIN")
		.antMatchers(HttpMethod.DELETE, "/doctor", "/admin").hasAuthority("ROLE_ADMIN")
		.antMatchers(HttpMethod.GET, "/doctor").hasAnyAuthority("ROLE_ADMIN","ROLE_PATIENT")
		.anyRequest()
		.authenticated()
		.and()
		.addFilter(new AuthenticationFilter(authenticationManager()))
		.addFilter(new AuthorizationFilter(authenticationManager()));

	}

	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
}
