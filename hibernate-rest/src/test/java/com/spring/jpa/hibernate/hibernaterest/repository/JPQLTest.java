package com.spring.jpa.hibernate.hibernaterest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.jpa.hibernate.hibernaterest.HibernateRestApplication;
import com.spring.jpa.hibernate.hibernaterest.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateRestApplication.class)
class JPQLTest {

	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 EntityManager em;
	 
	 @Test
	 public void findById() {
		List result = em.createQuery("select c from Course c").getResultList();
		logger.info("select c from Course c ->",result);
	 }
	 
	 @Test
	 public void findByIdTyped() {
		TypedQuery<Course> query = em.createQuery("select c from Course c where name like '%Spring%'", Course.class);
		List<Course> result = query.getResultList();
		logger.info("select c from Course c ->",result);
	 }
	 
	 
	 @Test
	 public void findByIdNAtiveQuery() {
		Query query = em.createNativeQuery("select * from Course c where id=?", Course.class);
		query.setParameter(1, 1001l);
		List<Course> result = query.getResultList();
		logger.info("select * from Course c where id=? ->",result);
	 }

}
