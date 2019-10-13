package com.skilldistillery.jobs.services;

import java.util.List;

import com.skilldistillery.jobs.entities.Technology;

public interface TechnologyService {

	List<Technology> findAllTechnologies();
	List<Technology> findByUsersId(Integer id);
	Technology findTechnologyById(Integer id);
	Technology createTechnology(Technology technology);
	Technology updateTechnology(int id, Technology technology);
	Technology deleteTechnology(int id);
	Technology createTechnologyOnUser(Technology technology, Integer userid);
	Technology createTechnologyOnApp(Technology technology, Integer appid);

}
