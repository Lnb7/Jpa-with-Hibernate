package com.spring.jpa.hibernate.hibernaterest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.jpa.hibernate.hibernaterest.entity.Course;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

	List<Course> findByName(String name);
	
	@Query(value = "select * from course where name like '%Spring'", nativeQuery = true)
	List<Course> nativeQuery();
	
}
