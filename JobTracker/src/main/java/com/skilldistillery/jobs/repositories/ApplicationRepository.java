package com.skilldistillery.jobs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobs.entities.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
