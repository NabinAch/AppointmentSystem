package com.appointment.appointmentAPI.user.repository;

import javax.transaction.Transactional;

import com.appointment.appointmentAPI.user.model.User;

@Transactional
public interface UserRepository extends UserBaseRepository<User> {

}
