package com.spring.jpa.hibernate.hibernaterest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.jpa.hibernate.hibernaterest.Repository.CourseRepository;
import com.spring.jpa.hibernate.hibernaterest.Repository.CourseSpringDataRepository;
import com.spring.jpa.hibernate.hibernaterest.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernateRestApplication.class)
class CourseSpringRepositoryTest {

   private Logger logger = LoggerFactory.getLogger(this.getClass());
	
   @Autowired
   CourseSpringDataRepository repo;
	
   @Test
	public void findById_CoursePresent() {
	 Optional<Course> result = repo.findById(1001l);
	 logger.info("CoursePresent -> {}" ,result.isPresent());
	 
	}
  
   @Test
  	public void findById_CourseNotPresent() {
  	 Optional<Course> result = repo.findById(1000l);
  	 logger.info("CoursePresent -> {}" ,result.isPresent());
  	 
  	}
   
   @Test
 	public void insertAndUpdateCourse() {
 	 Course course = new Course("Angular 8");
 	 repo.save(course);
 	 
 	 course.setName("Angular 8 - updated");
 	repo.save(course);
 	}
   
   @Test
 	public void findByName() {
 	 logger.info("CoursePresent -> {}" ,repo.findByName("Spring Boot tutorial"));
 	 
 	}
  
}
