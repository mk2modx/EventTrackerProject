package com.skilldistillery.jobs.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationTests {

	private static EntityManagerFactory emf;
	private EntityManager em;
	
	private Application app;
	private User user;
	private Technology tech;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	emf = Persistence.createEntityManagerFactory("JobTrackerPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		
		app = em.find(Application.class, 1);
		user = em.find(User.class, 1);
		tech = em.find(Technology.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		app = null;
		user = null;
		tech = null;
	}

	@Test
	void test() {
		assertNotNull(app);
	}
	@Test
	void test2() {
		assertEquals("Java",tech.getName());
		assertEquals("Mark",user.getFirstName());
		assertEquals("Java",user.getTechnologies().get(0).getName());
		assertEquals("MySQL",app.getTechnologies().get(0).getName());
	}

}
