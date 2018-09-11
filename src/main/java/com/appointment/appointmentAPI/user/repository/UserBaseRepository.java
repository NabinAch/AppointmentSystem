package com.appointment.appointmentAPI.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.appointment.appointmentAPI.user.model.UserEntity;

@NoRepositoryBean
public interface UserBaseRepository<T extends UserEntity> extends CrudRepository<T, Long> {

	public T findByEmail(String email);
}
