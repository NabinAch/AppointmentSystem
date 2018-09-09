package com.appointment.appointmentAPI.user.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Authority {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long authId;
	
	
	private String email;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private AuthorityRole authorityRole;

	public Long getAuthId() {
		return authId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AuthorityRole getAuthorityRole() {
		return authorityRole;
	}

	public void setAuthorityRole(AuthorityRole authorityRole) {
		this.authorityRole = authorityRole;
	}
	
}
