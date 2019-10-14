package com.skilldistillery.jobs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobs.entities.Application;
import com.skilldistillery.jobs.entities.Technology;
import com.skilldistillery.jobs.entities.User;
import com.skilldistillery.jobs.repositories.ApplicationRepository;
import com.skilldistillery.jobs.repositories.TechnologyRepository;
import com.skilldistillery.jobs.repositories.UserRepository;

@Service
public class TechnologyServiceImpl implements TechnologyService {

	@Autowired
	TechnologyRepository repo;
	@Autowired
	ApplicationRepository apprepo;
	@Autowired
	UserRepository userrepo;
	
	
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
	public Technology createTechnologyOnUser(Technology technology, Integer userid) {
		if (technology != null) {
			
			Optional<User> newuser = userrepo.findById(userid);
			if(newuser.isPresent()) {
				
				Technology tech = technology;
			
				User useMe = newuser.get();
			repo.saveAndFlush(tech);
			tech.setUser(useMe);
			System.out.println("*************");
			System.out.println(useMe.getFirstName());
			System.out.println("*************");
			repo.saveAndFlush(tech);
			}
		}
		return technology;
		
	}
	@Override
	public Technology createTechnologyOnApp(Technology technology, Integer appid) {
		if (technology != null) {
			Optional<Application> app = apprepo.findById(appid);
			if(app.isPresent()) {
				System.out.println("$$$$$$$$$$$" + technology.getName());
				Application app2 = app.get();
				System.out.println(app2.getTitle());
				Technology tech = repo.saveAndFlush(technology);
				tech.setApplication(app2);
				
				repo.saveAndFlush(tech);
			}
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
