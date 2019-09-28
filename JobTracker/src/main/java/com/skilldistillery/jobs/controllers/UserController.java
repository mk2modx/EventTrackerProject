package com.skilldistillery.jobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobs.entities.Application;
import com.skilldistillery.jobs.services.UserService;

@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	UserService usersvc;
	
	@GetMapping("ding")
	public String ping() {
		return "dong\n";
	}
	

}
