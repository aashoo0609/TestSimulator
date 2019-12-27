package com.yash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yash.model.Questions;

@Repository
public interface QuestionRepo extends JpaRepository<Questions, Integer> {

	@Query(value= "Select * from Questions where Subject_Id = ?1", nativeQuery= true)
	public List<Questions> getQuesBySubID(int id);
	
}
