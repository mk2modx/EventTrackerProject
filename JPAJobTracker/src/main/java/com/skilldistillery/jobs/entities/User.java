package com.skilldistillery.jobs.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String cohort;
	private String email;
	
	@OneToMany(mappedBy="user")
	private List<Application> applications;
	
	@ManyToMany(mappedBy="user")
	private List <Technology>technologies;

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public User() {
		super();
	}

	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", cohort=" + cohort
				+ ", email=" + email + ", applications=" + applications + ", technologies=" + technologies + "]";
	}


	public List<Application> getApplications() {
		return applications;
	}


	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}


	public List<Technology> getTechnologies() {
		return technologies;
	}


	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}


	public User(int id, String firstName, String lastName, String email, List<Application> applications,
			List<Technology> technologies) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.applications = applications;
		this.technologies = technologies;
	}


	public User(String firstName, String lastName, String email, List<Application> applications,
			List<Technology> technologies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.applications = applications;
		this.technologies = technologies;
	}


	public String getCohort() {
		return cohort;
	}


	public void setCohort(String cohort) {
		this.cohort = cohort;
	}


	public User(int id, String firstName, String lastName, String cohort, String email, List<Application> applications,
			List<Technology> technologies) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cohort = cohort;
		this.email = email;
		this.applications = applications;
		this.technologies = technologies;
	}


	public User(String firstName, String lastName, String cohort, String email, List<Application> applications,
			List<Technology> technologies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cohort = cohort;
		this.email = email;
		this.applications = applications;
		this.technologies = technologies;
	}
	
}
