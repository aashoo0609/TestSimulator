package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.dao.SubjectDAOImpl;
import com.yash.model.Subject;
import com.yash.repository.SubjectRepo;

@RestController
@CrossOrigin(origins = "*")
public class SubjectController {

	@Autowired 
	SubjectDAOImpl subService;
	
	@PostMapping("/saveSub")
	public Subject saveSub(@RequestBody Subject sub)
	{
		return subService.saveSubject(sub);
	}
	
	@GetMapping("/getSub")
	public List<Subject> getSub()
	{
		return subService.getSubject();
	}

}
