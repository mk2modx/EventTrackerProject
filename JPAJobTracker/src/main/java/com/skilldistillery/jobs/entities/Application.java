package com.skilldistillery.jobs.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job_application")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;

	private String link;
	@Column(name = "date_apply")
	private Date dateApply;
	@Column(name = "date_interview")
	private Date dateInterview;
	@Column(name = "contact_name")
	private String contactName;
	@Column(name = "contact_notes")
	private String contactNotes;
	@Column(name = "additional_notes")
	private String additionalNotes;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(mappedBy="applications")
	private List <Technology>technologies;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Date getDateApply() {
		return dateApply;
	}
	public void setDateApply(Date dateApply) {
		this.dateApply = dateApply;
	}
	public Date getDateInterview() {
		return dateInterview;
	}
	public void setDateInterview(Date dateInterview) {
		this.dateInterview = dateInterview;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactNotes() {
		return contactNotes;
	}
	public void setContactNotes(String contactNotes) {
		this.contactNotes = contactNotes;
	}
	public String getAdditionalNotes() {
		return additionalNotes;
	}
	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Application(int id, String title, String link, Date dateApply, Date dateInterview, String contactName,
			String contactNotes, String additionalNotes, String status) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.dateApply = dateApply;
		this.dateInterview = dateInterview;
		this.contactName = contactName;
		this.contactNotes = contactNotes;
		this.additionalNotes = additionalNotes;
		this.status = status;
	}
	public Application() {
		super();
	}
	public Application(String title, String link, Date dateApply, Date dateInterview, String contactName,
			String contactNotes, String additionalNotes, String status) {
		super();
		this.title = title;
		this.link = link;
		this.dateApply = dateApply;
		this.dateInterview = dateInterview;
		this.contactName = contactName;
		this.contactNotes = contactNotes;
		this.additionalNotes = additionalNotes;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Application [id=" + id + ", title=" + title + ", link=" + link + ", dateApply=" + dateApply
				+ ", dateInterview=" + dateInterview + ", contactName=" + contactName + ", contactNotes=" + contactNotes
				+ ", additionalNotes=" + additionalNotes + ", status=" + status + ", user=" + user + ", technologies="
				+ technologies + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Technology> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}
	public Application(int id, String title, String link, Date dateApply, Date dateInterview, String contactName,
			String contactNotes, String additionalNotes, String status, User user, List<Technology> technologies) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.dateApply = dateApply;
		this.dateInterview = dateInterview;
		this.contactName = contactName;
		this.contactNotes = contactNotes;
		this.additionalNotes = additionalNotes;
		this.status = status;
		this.user = user;
		this.technologies = technologies;
	}
	public Application(String title, String link, Date dateApply, Date dateInterview, String contactName,
			String contactNotes, String additionalNotes, String status, User user, List<Technology> technologies) {
		super();
		this.title = title;
		this.link = link;
		this.dateApply = dateApply;
		this.dateInterview = dateInterview;
		this.contactName = contactName;
		this.contactNotes = contactNotes;
		this.additionalNotes = additionalNotes;
		this.status = status;
		this.user = user;
		this.technologies = technologies;
	}

}
