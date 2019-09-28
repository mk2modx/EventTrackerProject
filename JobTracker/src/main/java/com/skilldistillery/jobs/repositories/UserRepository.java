package com.skilldistillery.jobs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobs.entities.Application;
import com.skilldistillery.jobs.entities.Technology;
import com.skilldistillery.jobs.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
}
