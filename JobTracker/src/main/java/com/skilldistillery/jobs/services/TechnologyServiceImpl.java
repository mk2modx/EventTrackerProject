package com.skilldistillery.jobs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobs.entities.Technology;
import com.skilldistillery.jobs.repositories.TechnologyRepository;

@Service
public class TechnologyServiceImpl implements TechnologyService {

	@Autowired
	TechnologyRepository repo;
	
	
	@Override
	public List<Technology> findAllTechnologies(){
		
		return repo.findAll();
	}
	
	@Override 
	public Technology findTechnologyById(Integer id) {
		
		Optional<Technology> tech = repo.findById(id);
		if(tech.isPresent()) {
			tech.get();
		}
		
		
		return tech.get();
	}
	
	@Override 
	public List<Technology> findByUsersId(Integer id){
		
		return repo.findByUsersId(id);
	}
	
	@Override
	public Technology createTechnology(Technology technology) {
		if (technology != null) {
			Technology tech = repo.saveAndFlush(technology);
		}
		return technology;
	
	}
	@Override
	public Technology updateTechnology(int id, Technology technology) {
		Optional<Technology> tech = repo.findById(id);
		if (tech.isPresent()) {
			Technology updateTech = tech.get();
			updateTech.setName(technology.getName());
			updateTech.setLink(technology.getLink());
			repo.saveAndFlush(updateTech);
		}
		return technology;
	}
	@Override
	public Technology deleteTechnology(int id) {
		repo.deleteById(id);
		return null;
	}
}
