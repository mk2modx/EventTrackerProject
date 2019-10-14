package com.skilldistillery.jobs.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Technology {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String link;
	
	@JsonIgnore
	@JoinColumn(name="job_application_id")
	private Application application;
	@JsonIgnore
	@JoinColumn(name="user_id")
	private User user;

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

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Technology [id=" + id + ", name=" + name + ", link=" + link + ", application=" + application + ", user="
				+ user + "]";
	}

	public Technology(int id, String name, String link, Application application, User user) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.application = application;
		this.user = user;
	}

	public Technology(String name, String link, Application application, User user) {
		super();
		this.name = name;
		this.link = link;
		this.application = application;
		this.user = user;
	}

	
	
}
