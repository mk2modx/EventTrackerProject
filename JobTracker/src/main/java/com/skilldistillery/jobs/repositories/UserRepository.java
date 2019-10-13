package com.skilldistillery.jobs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.jobs.entities.Application;
import com.skilldistillery.jobs.entities.Technology;
import com.skilldistillery.jobs.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

List<User> findByCohortContaining(String string);

}
