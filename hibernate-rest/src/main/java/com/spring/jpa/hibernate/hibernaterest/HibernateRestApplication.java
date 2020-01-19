package com.spring.jpa.hibernate.hibernaterest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.jpa.hibernate.hibernaterest.Repository.CourseRepository;
import com.spring.jpa.hibernate.hibernaterest.Repository.StudentRepository;
import com.spring.jpa.hibernate.hibernaterest.entity.Course;
import com.spring.jpa.hibernate.hibernaterest.entity.Review;

@SpringBootApplication
public class HibernateRestApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repo;
	
	@Autowired
	private StudentRepository stdRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	/*	Course course = repo.findById(1001l);
		logger.info("Course Details of 1001 -> {}",course);
		
		//repo.deleteById(1002l);
		
		repo.save(new Course("MicroService Tutorial"));
		
		*/
		
		//repo.PlayWithEntityManager();
		
		//stdRepo.saveStudentWithPassport();
		//stdRepo.retriveStudentAndPassport();
		
		//stdRepo.updateStudentAndPassport();
		
		//stdRepo.retrivePassportAndStudent();
		
		//repo.addHardCordedReviewsForCourse();
		
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5","Great Hands On"));
		 reviews.add(new Review("4","Great Videos"));
		 
		// repo.addReviewsForCourse(1003l, reviews);
		 
		// stdRepo.retriveStudentAndCourse();
		 
		 stdRepo.insertStudentAndCourse();
	}

}
