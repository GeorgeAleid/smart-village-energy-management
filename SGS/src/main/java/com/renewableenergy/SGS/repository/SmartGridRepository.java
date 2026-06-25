package com.renewableenergy.SGS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renewableenergy.SGS.entity.SmartGrid;

public interface SmartGridRepository extends JpaRepository<SmartGrid,Long> {
	

}
/*
 * 
 	 I tried to make this update:
	  @Repository 
	  public interface GenericDao<T extends BaseEntity> extends JpaRepository<T, Long> {
	       					T findByCode(String code); 
	       					T findById(Long id); 
	   }
 	       					
 	       					
	 I've created a @Entity public abstract class BaseEntity {...} and all my entities extend that class.
	 The application starts but I've got a problem with Hibernate
	 
	 
	 
 */