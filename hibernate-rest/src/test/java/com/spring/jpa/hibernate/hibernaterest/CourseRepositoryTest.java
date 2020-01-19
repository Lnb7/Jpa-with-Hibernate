package com.spring.jpa.hibernate.hibernaterest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.jpa.hibernate.hibernaterest.Repository.CourseRepository;
import com.spring.jpa.hibernate.hibernaterest.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernateRestApplication.class)
class CourseRepositoryTest {

   private Logger logger = LoggerFactory.getLogger(this.getClass());
	
   @Autowired
   CourseRepository repo;
	
   @Test
	public void findById() {
		
	   Course course = repo.findById(1001l);
	   //logger.info("Test is running");
	   assertEquals("JPA tutorial",course.getName());
	}
  
   
   @Test
   @DirtiesContext
  	public void save() {
	  //get course
	  Course course = repo.findById(1001l);
	  assertEquals("JPA tutorial",course.getName());
	  
	  //update details
	  course.setName("JPA Tutorial -updated");
	  repo.save(course);
	  
	  //check values
	  Course course1 = repo.findById(1001l);
	  assertEquals("JPA Tutorial -updated", course1.getName());
	  
	  
  	}
    
   @Test
   @DirtiesContext
  	public void deleteById() {
	   repo.deleteById(1002l);
  	   assertNull(repo.findById(1002l));
  	}
   
   
   @Test
   @DirtiesContext
   public void PlayWithEntityManager() {
	   repo.PlayWithEntityManager();
   }
   

}
