package com.skilldistillery.jobs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobs.entities.Technology;
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

	@GetMapping("technologies")
	public List<Technology> findAllTechnologies() {
		return techsvc.findAllTechnologies();
	}

	@GetMapping("technologies/users/{id}")
	public List<Technology> showTechnologiesByUserId(@PathVariable int id) {
		return techsvc.findByUsersId(id);
	}

	@GetMapping("technologies/{id}")
	public Technology findTechnologyById(@PathVariable int id) {
		return techsvc.findTechnologyById(id);
	}

	@PostMapping("technologies/create")
	public Technology createTechnology(@RequestBody Technology technology) {
		return techsvc.createTechnology(technology);
	}

	@PutMapping("technologies/{id}")
	public Technology updateTechnology(@PathVariable int id, @RequestBody Technology technology) {
		return techsvc.updateTechnology(id, technology);
	}

	@DeleteMapping("technologies/{id}")
	public Technology deleteTechnology(@PathVariable int id) {
		return techsvc.deleteTechnology(id);
	}

}