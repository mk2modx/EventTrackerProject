package com.skilldistillery.jobs.services;

import java.util.List;

import com.skilldistillery.jobs.entities.User;

public interface UserService {
	List<User> findAllUsers();
	User findByUserId(Integer id);
	User createUser(User user);
	User updateUserById(Integer id, User user);
	User deleteUserById(Integer id);

}
