package com.skilldistillery.jobs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobs.entities.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

	
	List<Technology> findByUsersId(Integer id);
}
