package com.skilldistillery.jobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobs.services.TechnologyService;

@RestController
@RequestMapping("api")
public class TechnologyController {

	@Autowired
	TechnologyService techsvc;
	
	@GetMapping("wig")
	public String ping() {
		return "wam\n";
	}
	
}
