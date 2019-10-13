package com.skilldistillery.jobs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.jobs.entities.Application;
import com.skilldistillery.jobs.entities.User;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

	List<Application> findByUserId(Integer id);
	
	List<Application> findByTitleContaining(String title);

	@Query(value="SELECT a From Application a JOIN FETCH a.user WHERE a.id = :id")
	Application findByAppId(@Param("id") int id);
	
	
	
}
