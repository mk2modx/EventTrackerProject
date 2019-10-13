package com.skilldistillery.jobs.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobs.entities.Application;
import com.skilldistillery.jobs.services.ApplicationService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4201"})
public class ApplicationController {

	@Autowired
	ApplicationService appsvc;

	@GetMapping("ping")
	public String ping() {
		return "pong\n";
	}

	@GetMapping("application/{id}")
	public Application findApplicationById(@PathVariable("id") Integer userId) {
		return appsvc.findApplicationById(userId);
	}
	@GetMapping("applications")
	public List<Application> findAllApplications() {
		return appsvc.findAllApplications();
	}

	@GetMapping("applications/{id}")
	public List<Application> showApplicationsByUserId(@PathVariable int id) { // user provided
		return appsvc.findByUserId(id);
	}

	@PostMapping("applications/{id}")
	public Application createApplicationOnUser(@PathVariable("id") Integer id, @RequestBody Application application,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			Application app = appsvc.createApplicationtOnUser(id, application);
			response.setStatus(201);
			StringBuffer url = request.getRequestURL();
			url.append("/");
			url.append(app.getId());
			response.setHeader("Location", url.toString());

		} catch (Exception e) {
			response.setStatus(400);
			application = null;
			e.printStackTrace();
		}

		return application;

	}

	@PutMapping("{uId}/applications/{aId}")
	public Application updateApplicationOnUser(@PathVariable("uId") Integer userId, @PathVariable("aId") Integer appId,
			@RequestBody Application application) {
		return appsvc.updateApplicationOnUser(userId, appId, application);

	}

	@DeleteMapping("{uId}/applications/{aId}")
	public void deleteApplicationOnUser(@PathVariable("uId") Integer userId, @PathVariable("aId") Integer appId) {

		appsvc.deleteApplicationOnUser(userId, appId);

	}

	@GetMapping("applications/search/{keyword}")
	public List<Application> getApplicationsByKeyword(@PathVariable("keyword") String word) {
		return appsvc.findByTitleContaining(word);
	}

}
