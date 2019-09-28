package com.skilldistillery.jobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobs.services.ApplicationService;

@RestController
@RequestMapping("api")
public class ApplicationController {
	
	@Autowired 
	ApplicationService appsvc;
	
	@GetMapping("ping")
	public String ping() {
		return "pong\n";
	}
	
}
