package com.skilldistillery.jobs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobs.repositories.TechnologyRepository;

@Service
public class TechnologyServiceImpl implements TechnologyService {

	@Autowired
	TechnologyRepository repo;
	
	
}
