package com.skilldistillery.jobs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobs.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
