package com.skilldistillery.jobs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobs.entities.Application;
import com.skilldistillery.jobs.entities.Technology;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

	List<Application> findByUserId(Integer id);
	
	List<Application> findByTitleContaining(String title);
}
