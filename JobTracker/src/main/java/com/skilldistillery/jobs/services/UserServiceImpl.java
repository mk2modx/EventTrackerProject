package com.skilldistillery.jobs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobs.entities.User;
import com.skilldistillery.jobs.repositories.ApplicationRepository;
import com.skilldistillery.jobs.repositories.TechnologyRepository;
import com.skilldistillery.jobs.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Autowired 
	private TechnologyRepository techrepo;
	
	@Autowired
	private ApplicationRepository apprepo;
	
	@Override
	public List<User> findAllUsers(){
		return repo.findAll();
	}
	

	@Override
	public User findByUserId(Integer id) {
		Optional<User> user = repo.findById(id);
		if(user.isPresent()) {
			user.get();
		}
		return user.get();
	}


	@Override
	public User createUser(User user) {
		if (user != null) {
			User newUser = repo.saveAndFlush(user);
		}
		return user;
	}


	@Override
	public User updateUserById(Integer id, User user) {
		Optional<User> use = repo.findById(id);
		
		if(use.isPresent()) {
			User updateUser = use.get();
			updateUser.setFirstName(user.getFirstName());
			updateUser.setLastName(user.getLastName());
			updateUser.setEmail(user.getEmail());
			updateUser.setCohort(user.getCohort());
			repo.saveAndFlush(updateUser);
		}
		
		return user;
	}


	@Override
	public User deleteUserById(Integer id) {
		repo.deleteById(id);
		return null;
	}
	
	@Override
	public List <User> findByCohortContaining(String cohort){
		return repo.findByCohortContaining(cohort);
	}
}
