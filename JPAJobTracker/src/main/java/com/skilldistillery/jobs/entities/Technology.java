package com.skilldistillery.jobs.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Technology {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String link;

	@ManyToMany
	@JoinTable(name = "job_application_technology", joinColumns = @JoinColumn(name = "technology_id"), inverseJoinColumns = @JoinColumn(name = "job_application_id"))
	private List<Application> applications;
	
	@ManyToMany
	@JoinTable(name = "technology_user", joinColumns = @JoinColumn(name = "technology_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Technology(int id, String name, String link) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
	}

	public Technology() {
		super();
	}

	public Technology(String name, String link) {
		super();
		this.name = name;
		this.link = link;
	}

	@Override
	public String toString() {
		return "Technology [id=" + id + ", name=" + name + ", link=" + link + "]";
	}

}
