package com.yash.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.yash.model.Subject;
import com.yash.repository.SubjectRepo;

@Service
public class SubjectDAOImpl implements SubjectDAO{

	@Autowired
	private SubjectRepo srepo;
	
	@Override
	public Subject saveSubject(Subject sub)
	{
		return srepo.save(sub);
	}
	
	@Override
	public List<Subject> getSubject()
	{
		return srepo.findAll();
	}
}
