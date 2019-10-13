package com.skilldistillery.jobs.controllers;

import java.util.List;

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

import com.skilldistillery.jobs.entities.Technology;
import com.skilldistillery.jobs.entities.User;
import com.skilldistillery.jobs.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4201"})
public class UserController {

	@Autowired
	UserService usersvc;
	
	@GetMapping("ding")
	public String ping() {
		return "dong\n";
	}


	@GetMapping("users")
	public List<User> findallUsers(){
		return usersvc.findAllUsers();
	}
	
	@GetMapping("users/{id}")
	public User findUserById(@PathVariable("id") Integer id) {
		return usersvc.findByUserId(id);
	}
	
	@PostMapping("users/create")
	public User createUser(@RequestBody User user) {
		return usersvc.createUser(user);
	}
	@PutMapping("users/{id}")
	public User updateUser(@PathVariable("id") Integer id , @RequestBody User user){
		return usersvc.updateUserById(id, user);
		
	}
		@DeleteMapping("users/{id}")
		public User deleteUser(@PathVariable Integer id) {
			return usersvc.deleteUserById(id);
	}
	@GetMapping("users/search/{keyword}")
	public List<User> getUsersByKeyword(@PathVariable("keyword") String word){
		return usersvc.findByCohortContaining(word);
	}
}
