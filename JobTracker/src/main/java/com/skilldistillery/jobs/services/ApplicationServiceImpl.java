package com.skilldistillery.jobs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobs.entities.Application;
import com.skilldistillery.jobs.entities.User;
import com.skilldistillery.jobs.repositories.ApplicationRepository;
import com.skilldistillery.jobs.repositories.UserRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository repo;

	@Autowired
	private UserRepository userepo;

	@Override
	public List<Application> findAllApplications() {

		return repo.findAll();

	}

	@Override
	public List<Application> findByUserId(Integer id) {
		return repo.findByUserId(id);
	}

	@Override
	public Application createApplicationtOnUser(Integer userId, Application application) {

		Optional<User> managedUser = userepo.findById(userId);

		if (managedUser.isPresent()) {

			application.setUser(managedUser.get());
		}
		Application app = repo.saveAndFlush(application);

		return application;
	}

	@Override
	public Application updateApplicationOnUser(Integer userId, Integer appId, Application application) {

		Optional<Application> managedApp = repo.findById(appId);
		if (managedApp.isPresent()) {

			Application actualApp = managedApp.get();
			actualApp.setTitle(application.getTitle());
			actualApp.setLink(application.getLink());
			actualApp.setDateApply(application.getDateApply());
			actualApp.setDateInterview(application.getDateInterview());
			actualApp.setContactName(application.getContactName());
			actualApp.setContactNotes(application.getContactNotes());
			actualApp.setAdditionalNotes(application.getAdditionalNotes());
			actualApp.setStatus(application.getStatus());

			repo.saveAndFlush(actualApp);
		}

		return application;

	}

	@Override
	public Application deleteApplicationOnUser(Integer userId, Integer appId) {

		repo.deleteById(appId);

		return null;

	}
	
	@Override
	public List<Application> findByTitleContaining(String title){
		return repo.findByTitleContaining(title);
		
	}
}
