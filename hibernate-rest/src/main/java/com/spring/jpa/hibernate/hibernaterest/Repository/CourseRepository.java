package com.spring.jpa.hibernate.hibernaterest.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.jpa.hibernate.hibernaterest.entity.Course;
import com.spring.jpa.hibernate.hibernaterest.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	//find by id
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	//save 
	public Course save(Course course) {
		if(course.getId()==null) {
			em.persist(course);
		}
		else {
			em.merge(course);
		}
		return course;
	}
	
	//delete by id
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	
	 public void PlayWithEntityManager() {
		 Course course = new Course("Spring Mvc Tutorial");
		 em.persist(course);
		 course.setName("Spring Mvc Tutorial - updated");
	   }
	 
	 public void addHardCordedReviewsForCourse() {
		 
		 //get the courses
		 Course course = findById(1003l);
		 logger.info("Course -> {}", course);
		 
		 //add 2 reviews
		 Review review1 = new Review("5","Great Hands On");
		 Review review2 = new Review("4","Great Videos");
		 
		 //seting realtions
		 course.addReviews(review1);
		 review1.setCourse(course);
		 
		 course.addReviews(review2);
		 review2.setCourse(course);
		 
		 //save to database
		 em.persist(review1);
		 em.persist(review2);
		 
	 }
	 
	 
	 public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		 
		 //get the courses
		 Course course = findById(courseId);
		 logger.info("Course -> {}", course);
	
		
		 for (Review review : reviews) {
			 //seting realtions
			 course.addReviews(review);
			 review.setCourse(course);
			//save to database
			 em.persist(review);
		}
		 
	 }
}

















