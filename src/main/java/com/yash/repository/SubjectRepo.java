package com.yash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.model.Subject;

@Repository
public interface SubjectRepo  extends JpaRepository<Subject, Integer>{

	
	
}
