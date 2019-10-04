package com.skilldistillery.jobs.services;

import java.util.List;

import com.skilldistillery.jobs.entities.Application;

public interface ApplicationService {
	List<Application> findByUserId(Integer id);
	Application createApplicationtOnUser(Integer userId, Application application);
	Application updateApplicationOnUser(Integer userId, Integer appId, Application application);
	Application deleteApplicationOnUser(Integer userId, Integer appId);
	List<Application> findAllApplications();
	List<Application> findByTitleContaining(String title);
	Application findApplicationById(Integer id);

}
