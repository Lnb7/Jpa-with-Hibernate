package com.spring.jpa.hibernate.hibernaterest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.jpa.hibernate.hibernaterest.Repository.CourseRepository;
import com.spring.jpa.hibernate.hibernaterest.Repository.StudentRepository;
import com.spring.jpa.hibernate.hibernaterest.entity.Course;
import com.spring.jpa.hibernate.hibernaterest.entity.Passport;
import com.spring.jpa.hibernate.hibernaterest.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HibernateRestApplication.class)
class StudentRepositoryTest {

   private Logger logger = LoggerFactory.getLogger(this.getClass());
	
   @Autowired
   StudentRepository repo;
   
   @Autowired
   EntityManager em;
	
   @Test
	public void retriveStudentAndPassport() {
	   Student student = em.find(Student.class, 2001l);
	   logger.info("Student -> {}",student);
	   logger.info("Passport -> {}", student.getPassport());
   }
  
   @Test
   @Transactional
  	public void updateStudentAndPassport() {
  	  //retrive std
	   Student student = em.find(Student.class, 2001l);
  	  
	   //retrive pass
	   Passport pass = student.getPassport();
	   
	   //update passport
	   pass.setNumber("A123456");
	   
	   //update Student
	   student.setName("Loki updated");
	   
     }
      
   
   @Test
   @Transactional
  	public void retrivePassportAndStudent() {
  	  
	   //retrive pass
	   Passport pass = em.find(Passport.class, 4001l);
	   
	   logger.info("Passport  -> {}",pass);
	   logger.info("Student -> {}", pass.getStudent());
	   
     }

}
