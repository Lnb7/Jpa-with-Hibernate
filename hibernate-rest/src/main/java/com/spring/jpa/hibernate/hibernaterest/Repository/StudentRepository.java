package com.spring.jpa.hibernate.hibernaterest.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.jpa.hibernate.hibernaterest.entity.Course;
import com.spring.jpa.hibernate.hibernaterest.entity.Passport;
import com.spring.jpa.hibernate.hibernaterest.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	//find by id
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	
	//save 
	public Student save(Student Student) {
		if(Student.getId()==null) {
			em.persist(Student);
		}
		else {
			em.merge(Student);
		}
		return Student;
	}
	
	//delete by id
	public void deleteById(Long id) {
		Student Student = findById(id);
		em.remove(Student);
	}
	
	
	 public void saveStudentWithPassport() {
		 Passport passport = new Passport("Z123456");
		 em.persist(passport);
		 
		 Student student = new Student("Mike");
		 
		 student.setPassport(passport);
		 em.persist(student);
	   }
	 
	 public void retriveStudentAndPassport() {
		 Student student = em.find(Student.class, 2001l);
		 logger.info("Student -> {}",student);
		 logger.info("Passport -> {}",student.getPassport());
	 }
	 
	 public void updateStudentAndPassport() {
		 Student student = em.find(Student.class, 2001l);
		 
		 Passport passport = student.getPassport();
		 
		 passport.setNumber("A123456");
		 
		 student.setName("Loki - Updated");
	 }
	 
	 
	 public void retrivePassportAndStudent() {
	  	  
		   //retrive pass
		   Passport pass = em.find(Passport.class, 4001l);
		   
		   logger.info("Passport  -> {}",pass);
		   logger.info("Student -> {}", pass.getStudent());
		   
    }
	
	 
	 public void retriveStudentAndCourse() {
		   Student student = em.find(Student.class, 2001l);
		   
		   logger.info("student  -> {}",student);
		   logger.info("course -> {}", student.getCourses());
		   
	 }
	 
	 public void insertStudentAndCourse() {
		   Student student = new Student("Jack");
		   
		   Course course = new Course("Micro Service");
		   
		   em.persist(student);
		   em.persist(course);
		   
		   student.addCourses(course);
		   course.addStudents(student);
		   
		   em.persist(student);
	 }
}




